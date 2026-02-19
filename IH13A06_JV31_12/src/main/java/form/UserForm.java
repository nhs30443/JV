package form;

import java.io.Serializable;

public class UserForm implements Serializable {
	private String name;	// jspのnameの値がsetNameを介して勝手に格納される
	private String message;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
