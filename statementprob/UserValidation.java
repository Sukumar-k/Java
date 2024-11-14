package statementprob;

public class UserValidation {

	public static void main(String[] args) {
	    int userid = 111;
	    int password = 224;
	    if(userid==password)
	    {
	    	System.out.println("Login Successful");
	    }
	    else {
	    	System.out.println("Login UnSuccessful");
	    }
	    if(userid!=password)
	    {
	    	System.out.println("Invalid user id");
	    }

	}

}
