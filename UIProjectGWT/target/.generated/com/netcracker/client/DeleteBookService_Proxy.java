package com.netcracker.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class DeleteBookService_Proxy extends RemoteServiceProxy implements com.netcracker.client.DeleteBookServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.netcracker.client.DeleteBookService";
  private static final String SERIALIZATION_POLICY ="903BC5C9F1E9F580249FFE5FA3C1E993";
  private static final com.netcracker.client.DeleteBookService_TypeSerializer SERIALIZER = new com.netcracker.client.DeleteBookService_TypeSerializer();
  
  public DeleteBookService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "deleteBook", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void deleteBook(com.netcracker.shared.Book book, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("DeleteBookService_Proxy", "deleteBook");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.netcracker.shared.Book/1085403211");
      streamWriter.writeObject(book);
      helper.finish(callback, ResponseReader.VOID);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
