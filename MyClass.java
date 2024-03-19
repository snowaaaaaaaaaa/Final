import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        List<Object> myList = new ArrayList<>();

        myList.add(new Object());
        myList.add(new Object());

       Comparator<? super Object> comparator = (o1, o2) -> 0;

        Collections.sort(myList, comparator);
    }
}
