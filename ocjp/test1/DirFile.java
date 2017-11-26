import java.io.*;

public class DirFile {
  public static void main(String[] args) {
    File dir = new File("dir");
    dir.mkdir();
    File f1 = new File(dir, "f1.txt");
    try {
      f1.createNewFile();
    } catch (IOException e) {}
    File newDir = new File("newDir");
    dir.renameTo(newDir);
  }
}

/*
Answer:
  The file system has a directory named newDir, containing a file f1.txt
*/

