package jdbcProject.com.yedam.temp;

public class ExitException extends Exception {
	private String msg;

	public ExitException(String msg) {
		this.msg = msg;
	}

	public void getMsg() {
		System.out.println(msg);
	}
}
