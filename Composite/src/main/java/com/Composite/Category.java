package com.Composite;

import java.util.ArrayList;
import java.util.List;

public class Category implements Component{
    List<Component> components;
    String name;

    public Category(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    @Override
    public void printComponentName() {
        components.forEach(Component::printComponentName);
    }

    public void addComponent(Component c) {
        components.add(c);
    }

    public void removeComponent(Component c) {
        components.remove(c);
    }
}
