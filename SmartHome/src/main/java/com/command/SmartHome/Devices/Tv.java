package com.command.SmartHome.Devices;

public class Tv implements Device{
    @Override
    public String on() {
        return "TV-On ";
    }

    @Override
    public String off() {
        return  "TV-Off ";
    }
}
