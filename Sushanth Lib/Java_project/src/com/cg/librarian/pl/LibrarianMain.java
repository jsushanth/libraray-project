package com.cg.librarian.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.librarian.bean.LibrarianBean;
import com.cg.librarian.exception.LibrarianException;
import com.cg.librarian.service.ILibrarianService;
import com.cg.librarian.service.LibrarianServiceImpl;

public class LibrarianMain {
static Scanner scan=new Scanner(System.in);
static ILibrarianService librarianService=null;
static LibrarianServiceImpl librarianServiceImpl=null;
public static void main(String[] args) {
	LibrarianBean librarianBean=null;
	String bookId=null;
	int option=0;
	while(true){
		
	System.out.println("Library Management System");
	System.out.println("--------------------------------");
	System.out.println("1.Add Book");
	System.out.println("2.Search Book");
	System.out.println("3.RetrieveAll details");
	System.out.println("4.Exit");
	System.out.println("Select your choice");
	try {
		option=scan.nextInt();
		switch (option) {
		case 1:
			while(librarianBean==null){
				librarianBean=populateLibrarianBean();
				
			}
			try {
				librarianService=new LibrarianServiceImpl();
				bookId=librarianService.addBook(librarianBean);
				System.out.println("book details has been successfully added");
				System.out.println("book id is"+bookId );
			} catch (LibrarianException librarianException) {
				System.out.println("error"+librarianException.getMessage());
				// TODO: handle exception
			}
			finally{
				bookId=null;
				librarianService=null;
				librarianBean=null;
				
			}
			break;
		case 2:
			try {
				librarianService=new LibrarianServiceImpl();
				System.out.println("Enter book id:");
				System.out.println(librarianService.searchBookDetails(scan.next()));
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			break;
		case 3:
			librarianService=new LibrarianServiceImpl();
			System.out.println("total number of books in the data base are:");
			if(librarianService.retrieveAll()!=null){
				System.out.println(librarianService.retrieveAll());
			}
			break;
		case 4:
			System.out.println("Your out of the page please try again");
			System.exit(0);
			break;
		default:
			break;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
private static LibrarianBean populateLibrarianBean(){
	LibrarianBean librarianBean=new LibrarianBean();
	System.out.println("\n Enter the details");
	System.out.println("Enter the book name");
	librarianBean.setBookName(scan.next());
	System.out.println("Enter the Book Type:");
	librarianBean.setBookType(scan.next());
	System.out.println("Enter the book Author");
	librarianBean.setBookAuthor(scan.next());
	System.out.println("Enter the cost of the book");
	try {
		librarianBean.setBookCost(scan.nextFloat());
	} catch (InputMismatchException ime) {
		scan.nextLine();
		System.out.println("Please enter the numeric value for the book cost");
		// TODO: handle exception
	}
	librarianServiceImpl=new LibrarianServiceImpl();
	try {
		librarianServiceImpl.validateLibrarian(librarianBean);
		return librarianBean;
	} catch (LibrarianException librarianException) {
		System.out.println("invalid data");
		System.out.println(librarianException.getMessage()+"\n try again");
		System.exit(0);
		// TODO: handle exception
	}
	return null;
}
}