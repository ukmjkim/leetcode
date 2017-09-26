import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class ExternalizablePair implements Externalizable {
  private String key;
  private String value;

  public ExternalizablePair() {
    this.key = null;
    this.value = null;
  }

  public ExternalizablePair(String key, String value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return "Pair ";
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeUTF(key);
    out.writeUTF(value);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    this.key = in.readUTF();
    this.value = in.readUTF();
  }
}

public class ExternalizableExample {
  private final static String OUTPUT_FILE = "externalizable_file";

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ExternalizablePair pair = new ExternalizablePair("Hello", "World");
    System.out.println("Initially: " + pair.toString());

    FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
    pair.writeExternal(objectOutputStream);

    objectOutputStream.flush();
    outputStream.close();

    ExternalizablePair copyOfPair = new ExternalizablePair();

    FileInputStream inputStream = new FileInputStream(OUTPUT_FILE);
    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
    copyOfPair.readExternal(objectInputStream);

    objectInputStream.close();
    inputStream.close();

    System.out.println("After de-serialization: " + copyOfPair.toString());
  }
}
