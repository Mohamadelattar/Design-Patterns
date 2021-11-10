package com.command.SmartHome.Command;

import com.command.SmartHome.Devices.Camera;
import com.command.SmartHome.Devices.Device;

public class CameraOnCommand implements Command{
    private Device camera = new Camera();
    @Override
    public void execute() {
        camera.on();
    }
}
