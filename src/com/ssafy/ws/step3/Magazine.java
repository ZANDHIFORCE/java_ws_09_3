package com.ssafy.ws.step3;


public class Magazine extends Book{
	protected int year;
	protected int month;
	protected Magazine(String string, String string2, String string3, String string4, int i, String string5, int j) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc,
			int quantity, int year, int month) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
		// TODO Auto-generated constructor stub
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", isbn=" + isbn + ", title=" + title + ", author="
				+ author + ", publisher=" + publisher + ", price=" + price + ", desc=" + desc + ", quantity=" + quantity
				+ "]";
	}

	
	
	
	
}
