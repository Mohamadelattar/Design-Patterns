package com.command.SmartHome.Devices;

public class Camera implements Device {

    @Override
    public String on() {
        return  "Camera-On ";
    }

    @Override
    public String off() {
        return "Camera-Off ";
    }
}
