package jdbcProject.com.yedam.temp;

public enum BrdMenu {
	ADD(1), DEL(2), EDIT(3), GET(4), LIST(5), EXIT(6);

	private int val;

	BrdMenu(int val) {
		this.val = val;
	}

	boolean equal(int val) {
		return this.val == val;
	}
}
