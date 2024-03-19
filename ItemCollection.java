import com.mycompany.ex02.Item2d;
import java.util.ArrayList;
import java.util.Observable;

public class ItemCollection extends Observable {
    private ArrayList<Item2d> items;

    public ItemCollection(ArrayList<Item2d> items) {
        this.items = items;
    }

    // Методи для додавання, видалення та зміни об'єктів колекції

    /**
     *
     */

    @Override
    public void notifyObservers() {
        super.notifyObservers(); // Викликаємо метод базового класу
        // Тут можна вказати додаткову логіку, яка виконується перед надсиланням повідомлення спостерігачам
    }

    void addObserver(GraphicDisplay aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
