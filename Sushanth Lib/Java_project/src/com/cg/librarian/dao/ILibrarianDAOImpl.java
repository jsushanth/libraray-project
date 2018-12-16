package com.cg.librarian.dao;

import java.io.IOException;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.librarian.bean.LibrarianBean;
import com.cg.librarian.exception.LibrarianException;
import com.cg.librarian.util.DBConnection;

public class ILibrarianDAOImpl implements ILibrarianDAO{

	@Override
	public String addBook(LibrarianBean librarian) throws ClassNotFoundException, IOException, SQLException {
		
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String bookId=null;
		int queryResult=0;
		try {
		preparedStatement=connection.prepareStatement("insert into Librarian_details values(bookId_sequence.nextval,?,?,?,?)");
		
		preparedStatement.setString(1,librarian.getBookName());
		preparedStatement.setString(2, librarian.getBookType());
		preparedStatement.setString(3,librarian.getBookAuthor());
		preparedStatement.setFloat(4, librarian.getBookCost());
		preparedStatement.executeUpdate();
		Statement st=connection.createStatement();
		resultSet=st.executeQuery("select max(bookid) from Librarian_details");
		if(resultSet.next()){
			bookId=resultSet.getString(1);
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return bookId;
	}

	@Override
	public LibrarianBean searchBookDetails(String bookId) throws LibrarianException, ClassNotFoundException, IOException, SQLException{
		// TODO Auto-generated method stub
		Connection connection=DBConnection.getConnection();
		LibrarianBean bean=null;
		try {
			Statement st=connection.createStatement();
			
				
			ResultSet rs=st.executeQuery("select * from Librarian_details where bookId='"+bookId+"'");
			bean=new LibrarianBean();
			while(rs.next()){
				bean.setBookId(rs.getInt(1));
				bean.setBookName(rs.getString(2));
				bean.setBookType(rs.getString(3));
				bean.setBookAuthor(rs.getString(4));
				bean.setBookCost(rs.getFloat(5));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return bean;
	}

		
	@Override
	public List retrieveAll() throws LibrarianException, ClassNotFoundException, IOException, SQLException{
		Connection connection=DBConnection.getConnection();
		List<LibrarianBean>li=new ArrayList<>();
		try {
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery("select * from Librarian_details");
			while(rs.next()){
				LibrarianBean bean=new LibrarianBean();
				bean.setBookId(rs.getInt(1));
				bean.setBookName(rs.getString(2));
				bean.setBookType(rs.getString(3));
				bean.setBookAuthor(rs.getString(4));
				bean.setBookCost(rs.getFloat(5));
			li.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return li;
	}

}
