package com.ssafy.ws.step3;

import java.util.*;

public class BookManagerImpl implements IBookManager{

	private static IBookManager instance;
	private List<Book> books= new ArrayList<>();
	
	private BookManagerImpl() {
	}
	
	public static IBookManager getInstance() {
		if(instance==null)
			instance = new BookManagerImpl();
		return instance;
	}
	
	@Override
	public void add(Book book) {
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getIsbn().equals(book.getIsbn()))
				return;
		}
		books.add(book);
	}

	@Override
	public void remove(String isbn) throws ISBNNotFoundException{
		Book b = searchByIsbn(isbn);
		if(b==null)
			throw new ISBNNotFoundException(isbn);
		
		books.remove(b);
	}

	@Override
	public Book[] getList() {
		return books.toArray(new Book[books.size()]);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getIsbn().equals(isbn)){
				return b;
			}
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		List<Book> bs = new ArrayList<>();
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getTitle().equals(title)){
				bs.add(b);
			}
		}
		return bs.toArray(new Book[bs.size()]);
	}

	@Override
	public Magazine[] getMagazines() {
		List<Book> ms = new ArrayList<>();
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b instanceof Magazine m){
				ms.add(m);
			}
		}
		return ms.toArray(new Magazine[ms.size()]);
	}

	@Override
	public Book[] getBooks() {
		List<Book> bs = new ArrayList<>();
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(!(b instanceof Magazine)){
				bs.add(b);
			}
		}
		return bs.toArray(new Book[bs.size()]);
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		Iterator<Book> iter = books.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			total += b.getPrice();
		}
		return total;
	}

	@Override
	public double getPriceAvg() {
		return this.getTotalPrice()/(double)books.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException{
		Book b = searchByIsbn(isbn);
		if(b==null)
			throw new ISBNNotFoundException(isbn);
		
		int remain = b.getQuantity() - quantity;
		
		if(remain<0)
			throw new QuantityException();
		
		
		if(remain==0)
			this.remove(isbn);
		else
			b.setQuantity(remain);

	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException{
		Book b = searchByIsbn(isbn);
		if(b==null)
				throw new ISBNNotFoundException(isbn);
		else
			b.setQuantity(b.getQuantity()+quantity);
		
	}
	
}
