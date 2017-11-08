import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {
  public static void main(String args[]) throws Exception {

    Type type = StringList.class.getGenericSuperclass();
    System.out.println(type); 
    ParameterizedType pt = (ParameterizedType) type;
    System.out.println(pt.getActualTypeArguments()[0]);

    /* expected output
     * java.util.ArrayList<java.lang.String>
     * class java.lang.String
     */
  }
}

class StringList extends ArrayList<String> {
}

