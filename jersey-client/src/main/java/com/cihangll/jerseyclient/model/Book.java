package com.cihangll.jerseyclient.model;

public class Book {

	private String isbn;
	private String description;
	private int pageNumber;
	private double price;

	public Book() {
	}

	public Book(String isbn, String description, int pageNumber, double price) {
		this.isbn = isbn;
		this.description = description;
		this.pageNumber = pageNumber;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", description='" + description + '\'' +
				", pageNumber=" + pageNumber +
				", price=" + price +
				'}';
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
