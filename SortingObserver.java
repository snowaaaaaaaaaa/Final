
package com.mycompany.ex02;

import java.util.Collections;
import java.util.List;

public class SortingObserver implements Observer {
    private final Collection collection;

    public SortingObserver(Collection collection) {
        this.collection = collection;
        collection.addObserver(this);
    }

    @Override
    public void update() {
        List<Object> elements = collection.getElements();
    }
}
