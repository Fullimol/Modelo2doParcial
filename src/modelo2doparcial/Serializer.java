package modelo2doparcial;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface Serializer<T> {

    void serializeToBinary(T obj, ObjectOutputStream  out) throws Exception;

    T deserializeFromBinary(ObjectInputStream ois) throws Exception;

    String serializeToJson(T obj) throws Exception;

    T deserializeFromJson(String json) throws Exception;
}
