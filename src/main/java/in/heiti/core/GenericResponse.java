package in.heiti.core;

public class GenericResponse {
	
	private boolean status;
	private String message;
	
	
	public GenericResponse(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}


	public static GenericResponse status(boolean status, String msg) {
		
		return new GenericResponse(status, msg);
	}
	
	
	

}
