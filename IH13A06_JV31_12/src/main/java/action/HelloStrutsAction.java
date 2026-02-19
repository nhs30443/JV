package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import form.UserForm;

public class HelloStrutsAction extends ActionSupport implements ModelDriven<UserForm> {
	UserForm userForm = new UserForm();
	
	@Override
	public UserForm getModel() {
		return userForm;
	}
	
	@Override
	public String execute() {
		if (userForm.getName() == null || userForm.getName() == "" ) {
			// 戻り値はフォワード先の設定名
			return SUCCESS;
		}
		
        if (userForm.getName().contains("ハク")) {
        	userForm.setMessage("ありがとう。私の本当の名は、ニギニギコハクンチョス");
        } else {
        	userForm.setMessage(userForm.getName() + " というのかい、贅沢な名だね！");
        }
        
		return "next";
	}
	
	public String confilm() {
        if (userForm.getName().contains("ハク")) {
        	userForm.setMessage("ありがとう。私の本当の名は、ニギニギコハクンチョス");
        } else {
        	userForm.setMessage(userForm.getName() + " というのかい、贅沢な名だね！");
        }
        
		return "next";
	}
}
