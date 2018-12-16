package com.cg.librarian.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.librarian.bean.LibrarianBean;
import com.cg.librarian.dao.ILibrarianDAO;
import com.cg.librarian.dao.ILibrarianDAOImpl;
import com.cg.librarian.exception.LibrarianException;

public class LibrarianServiceImpl implements ILibrarianService{
	ILibrarianDAO librariandao=new ILibrarianDAOImpl();

	@Override
	public String addBook(LibrarianBean librarian) throws LibrarianException, ClassNotFoundException, IOException, SQLException {
		String librarianSeq;
		librarianSeq=librariandao.addBook(librarian);
		return librarianSeq; 
		// TODO Auto-generated method stub
		
	}

	@Override
	public LibrarianBean searchBookDetails(String bookId) throws LibrarianException, ClassNotFoundException, IOException, SQLException {
		String b=bookId;
		LibrarianBean a=librariandao.searchBookDetails(bookId);
		return a;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List retrieveAll() throws LibrarianException, ClassNotFoundException, IOException, SQLException
	{
		List<LibrarianBean> li=new ArrayList<>();
		li=librariandao.retrieveAll();
		return li;
		// TODO Auto-generated method stub
		
	}

	public void validateLibrarian(LibrarianBean bean) throws LibrarianException{
		List<String> validationErrors=new ArrayList<String>();
		
		
		if(!(isValidBookName(bean.getBookName())))
		{
			validationErrors.add("\n Book name should be in alphabets and should have minimum 3 characerts:");
		}
		
		if(!(isValidBookType(bean.getBookType()))) {
			validationErrors.add("\n Book type  should have characters and  have minimum 3  characters");
		}
		
		if(!(isValidBookAuthor(bean.getBookAuthor()))) {
			validationErrors.add("\n  Book type  should have characters and  have minimum 3  characters ");
		}
		if(!(isValidBookCost(bean.getBookCost()))) {
			validationErrors.add("\n amount should be positive number");
		}
		if(!validationErrors.isEmpty()) {
			throw new LibrarianException(validationErrors +" ");
		}
	}
	private boolean isValidBookCost(float bookCost) {
		return bookCost>0;
	}
	private boolean isValidBookName(String bookName) {
		Pattern namePattern=Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(bookName);
		return nameMatcher.matches();
	}
	private boolean isValidBookType(String bookType) {
		Pattern typePattern=Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher typeMatcher=typePattern.matcher(bookType);
		return typeMatcher.matches();
		
	}
	private boolean isValidBookAuthor(String bookAuthor) {
		Pattern authorPattern=Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher authorMatcher=authorPattern.matcher(bookAuthor);
		return authorMatcher.matches();
	}
	public boolean validateBookId(String bookId) {
		Pattern idPattern=Pattern.compile("[0-9][1,4]");
		Matcher idMatcher=idPattern.matcher(bookId);
		if(idMatcher.matches())
			return true;
		else
		   return false;
		
	}
	}


	

