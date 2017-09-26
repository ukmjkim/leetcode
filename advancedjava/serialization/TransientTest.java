import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientTest {
  public static void main(String[] args) {
    Book narnia = new Book(1024, "Narnia", "unknown", 2);
    System.out.println("Before Serialization: " + narnia);

    try {
      FileOutputStream fos = new FileOutputStream("narnia.ser");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(narnia);
      oos.flush();
      fos.close();

      System.out.println("Book is successfully Serialized");

      FileInputStream fis = new FileInputStream("narnia.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      Book oldNarnia = (Book) ois.readObject();
      ois.close();
      fis.close();

      System.out.println("Book successfully created from Serialized data");
      System.out.println("Book after serialization : " + oldNarnia);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class Book implements Serializable {
  private int ISBN;
  private String title;
  private String author;
  private transient int edition = 1;

  public Book(int ISBN, String title, String author, int edition) {
    this.ISBN = ISBN;
    this.title = title;
    this.author = author;
    this.edition = edition;
  }

  @Override
  public String toString() {
    return "Book{" + "ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", edition=" + edition + "}";
  }
}

