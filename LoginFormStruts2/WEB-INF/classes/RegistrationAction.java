import java.util.*;
import java.io.*;
import com.opensymphony.xwork2.ActionSupport;
public class RegistrationAction extends ActionSupport {// RegistrationAction start

    private String email;
    private String password;
	private String confirmPassword; //signup
	private String action;
	public static final String SIGNUP = "signup";
	public static final String LOGIN = "login";
	public static final String FAIZAN="faizan";
	
	public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
	public String getConfirmPassword(){
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword){
		this.confirmPassword=confirmPassword;
	}
	
	
    
    @Override
    public void validate() {// validate() start
		
	
       
		
		if(action.equals("/index.jsp")){// action // 7
			
			if (email == null || email.trim().isEmpty()) {// 6
				addFieldError("email", "Email is required");
			} else{ 
				if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {// 5
					addFieldError("email", "Invalid email format");
				}else{// password check null or not start
					if (password == null || password.trim().isEmpty()) {// 4
						addFieldError("password", "Password is required");
					}else{// user and passward matching code start
					
						try{// 3
							Properties properties = new Properties();
							properties.load(new FileInputStream("D:/Tomcat/webapps/LoginFormStruts2/WEB-INF/classes/password.properties"));
							
							String checkPassword = properties.getProperty(email);
							
							if(!(checkPassword==null)){// 2
								if(password.equals(checkPassword)){// 1
									System.out.println("LOgin Successfully done");
								}else{
									addFieldError("password", "Password not matching....");
								}// 1
							}else{
								addFieldError("email", "Usre Name not matching....");
								
							}// 2
						}catch(Exception e){
							e.printStackTrace();
						}// 3
					
					
					}// user and passward matching code End // 4
				}// password check null or not End // 5
			
			}// 6
		   
		   
			
		}else{// action End
		
			
			
			if (email == null || email.trim().isEmpty()) {
				addFieldError("email", "Email is required");
			} else{ 
				if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
					addFieldError("email", "Invalid email format");
				}else{	
					if (password == null || password.trim().isEmpty()) {
						addFieldError("password", "Password is required");
					}else{
						if(confirmPassword== null || confirmPassword.trim().isEmpty()){
							addFieldError("confirmPassword", "Password is required");
						}else{
							if(!(password.equals(confirmPassword))){
								addFieldError("confirmPassword", "do not match password");
								System.out.println("Not match confirmPassword......");
							}else{
								Properties properties = new Properties();
								try{
									FileInputStream in = new FileInputStream("D:/Tomcat/webapps/LoginFormStruts2/WEB-INF/classes/password.properties");
									properties.load(in);
								}catch(Exception e){
									e.printStackTrace();
								}
								properties.setProperty(email, password);
								
								try {
									FileOutputStream f = new FileOutputStream("D:/Tomcat/webapps/LoginFormStruts2/WEB-INF/classes/password.properties");
									properties.store(f, "Usernames and Passwords");
									f.close();
									System.out.println("New user Add Record.....");
								} catch (IOException ex) {
									ex.printStackTrace();
								}
							
							
							}
						
						
						}	
					}
				}
			}
		
		}// 7
		
		
		
    }// validate() End

 
    public String execute() {// excute() start
		if(action.equals("/signup.jsp")){
			return SIGNUP;
		}else{
			if(action.equals("/index.jsp")){
				return LOGIN;
			}else{
				return SUCCESS;
			}
		}
    }// // excute() End
	
	
	
	

	

	
}// RegistrationAction End

































