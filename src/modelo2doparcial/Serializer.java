package modelo2doparcial;

import java.io.InputStream;
import java.io.OutputStream;

public interface Serializer<T> {

    void serializeToBinary(T obj, OutputStream out) throws Exception;

    T deserializeFromBinary(InputStream in) throws Exception;

    String serializeToJson(T obj) throws Exception;

    T deserializeFromJson(String json) throws Exception;
}
