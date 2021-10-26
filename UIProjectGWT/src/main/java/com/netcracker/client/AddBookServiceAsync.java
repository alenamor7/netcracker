package com.netcracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.netcracker.shared.Book;

public interface AddBookServiceAsync {
    void addBook(Book book, AsyncCallback callback);
}
