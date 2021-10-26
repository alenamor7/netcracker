package com.netcracker.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Book_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.netcracker.shared.Author getAuthor(com.netcracker.shared.Book instance) /*-{
    return instance.@com.netcracker.shared.Book::author;
  }-*/;
  
  private static native void setAuthor(com.netcracker.shared.Book instance, com.netcracker.shared.Author value) 
  /*-{
    instance.@com.netcracker.shared.Book::author = value;
  }-*/;
  
  private static native java.util.Date getDateAdded(com.netcracker.shared.Book instance) /*-{
    return instance.@com.netcracker.shared.Book::dateAdded;
  }-*/;
  
  private static native void setDateAdded(com.netcracker.shared.Book instance, java.util.Date value) 
  /*-{
    instance.@com.netcracker.shared.Book::dateAdded = value;
  }-*/;
  
  private static native int getId(com.netcracker.shared.Book instance) /*-{
    return instance.@com.netcracker.shared.Book::id;
  }-*/;
  
  private static native void setId(com.netcracker.shared.Book instance, int value) 
  /*-{
    instance.@com.netcracker.shared.Book::id = value;
  }-*/;
  
  private static native int getPages(com.netcracker.shared.Book instance) /*-{
    return instance.@com.netcracker.shared.Book::pages;
  }-*/;
  
  private static native void setPages(com.netcracker.shared.Book instance, int value) 
  /*-{
    instance.@com.netcracker.shared.Book::pages = value;
  }-*/;
  
  private static native int getPublishYear(com.netcracker.shared.Book instance) /*-{
    return instance.@com.netcracker.shared.Book::publishYear;
  }-*/;
  
  private static native void setPublishYear(com.netcracker.shared.Book instance, int value) 
  /*-{
    instance.@com.netcracker.shared.Book::publishYear = value;
  }-*/;
  
  private static native java.lang.String getTitle(com.netcracker.shared.Book instance) /*-{
    return instance.@com.netcracker.shared.Book::title;
  }-*/;
  
  private static native void setTitle(com.netcracker.shared.Book instance, java.lang.String value) 
  /*-{
    instance.@com.netcracker.shared.Book::title = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.Book instance) throws SerializationException {
    setAuthor(instance, (com.netcracker.shared.Author) streamReader.readObject());
    setDateAdded(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readInt());
    setPages(instance, streamReader.readInt());
    setPublishYear(instance, streamReader.readInt());
    setTitle(instance, streamReader.readString());
    
  }
  
  public static com.netcracker.shared.Book instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.Book();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.Book instance) throws SerializationException {
    streamWriter.writeObject(getAuthor(instance));
    streamWriter.writeObject(getDateAdded(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeInt(getPages(instance));
    streamWriter.writeInt(getPublishYear(instance));
    streamWriter.writeString(getTitle(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.Book_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.Book_FieldSerializer.deserialize(reader, (com.netcracker.shared.Book)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.Book_FieldSerializer.serialize(writer, (com.netcracker.shared.Book)object);
  }
  
}
