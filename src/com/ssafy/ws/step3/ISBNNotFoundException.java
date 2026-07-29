package com.ssafy.ws.step3;


public class ISBNNotFoundException extends Exception{
	private String isbn;
	public ISBNNotFoundException() {
		this("해당 isbn을 가진 책이 없습니다.");
	}
	public ISBNNotFoundException(String message) {
		super(message);
		this.isbn = message;
	}
	public String getIsbn(){
		return this.isbn;
	}
	
}