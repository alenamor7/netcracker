package com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.netcracker.shared.Book;


@RemoteServiceRelativePath("addBook")
public interface AddBookService extends RemoteService {
    void addBook(Book book);
}
