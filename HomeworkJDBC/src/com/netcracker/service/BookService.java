package com.netcracker.service;

import com.netcracker.dao.book.IBookDAO;
import com.netcracker.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService implements IBookService {

    @Autowired
    IBookDAO bookDAO;


    @Override
    public void saveBook(Book entity) {
        bookDAO.saveBook(entity);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bookDAO.findBookById(id);
    }

    @Override
    public void deleteBookById(int id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public long countRow() {
        return bookDAO.countRow();
    }

    @Override
    public List<String> getBooksByTitlePrice() {
        return bookDAO.getBooksByTitlePrice();
    }

    @Override
    public List getBooksByDistrictQtyMore10() {
        return bookDAO.getBooksByDistrictQtyMore10();
    }
}
