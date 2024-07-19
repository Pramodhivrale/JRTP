package com.example.binding;

public class BookBinding {
	private Integer bookId;
	private String bookName;

	private String bookAuthoer;

	public BookBinding() {

	}

	public BookBinding(Integer bookId, String bookName, String bookAuthoer) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthoer = bookAuthoer;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthoer() {
		return bookAuthoer;
	}

	public void setBookAuthoer(String bookAuthoer) {
		this.bookAuthoer = bookAuthoer;
	}

}
