package com.yedam.phonebook;

public class MenuChoiceException extends Exception{
	private int wrongChoice;
	
	public MenuChoiceException(int wrongChoice) {
		super("없는 메뉴번호 입니다.");
		this.wrongChoice = wrongChoice;
	}
	
	public void showWrongChoice() {
		System.out.println(wrongChoice + "는 없는 메뉴번호 입니다.");
	}
}
