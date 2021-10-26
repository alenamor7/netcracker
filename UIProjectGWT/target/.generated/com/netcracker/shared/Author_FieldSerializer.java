package com.netcracker.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Author_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.netcracker.shared.Author instance) throws SerializationException {
    instance.name = streamReader.readString();
    instance.surname = streamReader.readString();
    
  }
  
  public static com.netcracker.shared.Author instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.netcracker.shared.Author();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.netcracker.shared.Author instance) throws SerializationException {
    streamWriter.writeString(instance.name);
    streamWriter.writeString(instance.surname);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.netcracker.shared.Author_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.netcracker.shared.Author_FieldSerializer.deserialize(reader, (com.netcracker.shared.Author)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.netcracker.shared.Author_FieldSerializer.serialize(writer, (com.netcracker.shared.Author)object);
  }
  
}
