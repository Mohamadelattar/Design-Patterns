package com.command.pattern.models;

public class KirbyCharacterReceiver {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveUp() {
        System.out.println(getName() + " jumping up");
    }

    public void moveRight() {
        System.out.println(getName() + " jumping right");
    }

    public void moveLeft() {
        System.out.println(getName() + " jumping left");
    }

    public void moveDown() {
        System.out.println(getName() + " jumping down");
    }

}
