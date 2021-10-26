package com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.netcracker.shared.Book;

@RemoteServiceRelativePath("deleteBook")
public interface DeleteBookService extends RemoteService {
    void deleteBook(Book book);
}