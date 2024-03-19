
import com.mycompany.ex02.Observer;

public class GraphicDisplay implements Observer {
    private ItemCollection itemCollection;

    public GraphicDisplay(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
        itemCollection.addObserver(this); // Додаємо себе як спостерігача до колекції
    }

    @Override
    public void update() {
        // Логіка для оновлення графічного відображення при оновленні колекції
    }
}
