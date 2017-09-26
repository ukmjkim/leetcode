import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;

class SerializablePair implements Serializable {
  private static final long serialVersionUID = 2616423033716253195L;

  private String key = null;
  private String value = null;

  public SerializablePair(String key, String value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return "Pair ";
  }
}

public class SerializableExample {
  private final static String OUTPUT_FILE = "serializable_file";

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    SerializablePair pair = new SerializablePair("Hello", "World");
    System.out.println("Initially: " + pair.toString());

    FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    objectOutputStream.writeObject(pair);

    objectOutputStream.flush();
    outputStream.close();

    SerializablePair copyOfPair = null;

    FileInputStream inputStream = new FileInputStream(OUTPUT_FILE);
    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
    copyOfPair = (SerializablePair) objectInputStream.readObject();

    objectInputStream.close();
    inputStream.close();

    System.out.println("After de-serialization: " + copyOfPair.toString());
  }
}


