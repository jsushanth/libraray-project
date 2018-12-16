package com.cg.librarian.bean;

public class LibrarianBean {
private int bookId;
private String bookName;
private String bookType;
private String bookAuthor;
private float bookCost;
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getBookType() {
	return bookType;
}
public void setBookType(String bookType) {
	this.bookType = bookType;
}
public String getBookAuthor() {
	return bookAuthor;
}
public void setBookAuthor(String bookAuthor) {
	this.bookAuthor = bookAuthor;
}
public float getBookCost() {
	return bookCost;
}
public void setBookCost(float bookCost) {
	this.bookCost = bookCost;
}
@Override
public String toString() {
	return "LibrarianBean [bookId=" + bookId + ", bookName=" + bookName
			+ ", bookType=" + bookType + ", bookAuthor=" + bookAuthor
			+ ", bookCost=" + bookCost + "]";
}



}
