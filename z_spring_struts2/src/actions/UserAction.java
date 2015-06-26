package actions;

import pojo.User;
import servcie.UserManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String uname;
	private String psd;
	private UserManager um;
	
	
	public void setUm(UserManager um) {
		this.um = um;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String login(){
		System.out.println("login.....");
		User u=um.login(uname, psd);
		if(u!=null){
			ActionContext.getContext().getSession().put("u", u);
			return SUCCESS;
		}
		else{
			return INPUT;
		}
		
	}
	
	public String listUserInfo(){
		return SUCCESS;
	}
}
