package com.ssafy.ws.step3;


public class BookTest {

	public static void main(String[] args) {
		IBookManager manager = BookManagerImpl.getInstance();
		manager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10));
        manager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20));
        manager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30));
        manager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1) );
		System.out.println("**********************Book List**********************");
		printBooks(manager.getList());
		System.out.println("**********************Books**********************");
		printBooks(manager.getBooks());
		System.out.println("**********************Magazines**********************");
		printBooks(manager.getMagazines());
		System.out.println("**********************AVG**********************");
		System.out.println(manager.getTotalPrice());
		System.out.println(manager.getPriceAvg());
		System.out.println("**********************Sell: (21424,11)**********************");
		try {
			manager.sell("21424", 11);
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		} catch (QuantityException e) {
			System.out.println("수량이 부족합니다.");
		}
		System.out.println("**********************Buy: (21424,10)**********************");
		try {
			manager.buy("21424", 10);
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(manager.searchByIsbn("21424"));
		System.out.println("**********************Sell: (21424,11)**********************");
		try {
			manager.sell("21424", 11);
		} catch (ISBNNotFoundException e) {
			e.printStackTrace();
		} catch (QuantityException e) {
			System.out.println("수량이 부족합니다.");
		}
		System.out.println(manager.searchByIsbn("21424"));
	}
	public static void printBooks(Book[] bs) {
		for(Book b:bs)
			System.out.println(b);
	}
}
