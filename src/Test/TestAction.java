package Test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Override 
    public String execute() throws Exception { 
		System.out.println("wanglei is cool");
		return SUCCESS;
	}
}
