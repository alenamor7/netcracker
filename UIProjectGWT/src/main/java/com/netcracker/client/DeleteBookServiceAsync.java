package com.netcracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.netcracker.shared.Book;

public interface DeleteBookServiceAsync {
    void deleteBook(Book book, AsyncCallback callback);
}
