package com.netcracker.service;

import com.netcracker.model.Book;

import java.util.List;

public interface IBookService {
    void saveBook(Book entity);

    List<Book> findAllBooks();

    Book findBookById(int id);

    void deleteBookById(int id);

    long countRow();

    List<String> getBooksByTitlePrice();

    List getBooksByDistrictQtyMore10();
}
