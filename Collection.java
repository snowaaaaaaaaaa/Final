// Collection.java
package com.mycompany.ex02;

import java.util.ArrayList;
import java.util.List;

public class Collection implements Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addElement(Object element) {
        // Додати елемент до колекції
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    List<Object> getElements() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
