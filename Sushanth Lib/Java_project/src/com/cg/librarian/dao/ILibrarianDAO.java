package com.cg.librarian.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.librarian.bean.LibrarianBean;
import com.cg.librarian.exception.LibrarianException;

public interface ILibrarianDAO {
	public String addBook(LibrarianBean librarian)throws LibrarianException, ClassNotFoundException, IOException, SQLException;
	public LibrarianBean searchBookDetails(String bookId)throws LibrarianException, ClassNotFoundException, IOException, SQLException;
	public List<LibrarianBean> retrieveAll()throws LibrarianException, ClassNotFoundException, IOException, SQLException;
	
	

}
