package com.command.SmartHome.Command;

import com.command.SmartHome.Devices.Camera;
import com.command.SmartHome.Devices.Device;

public class CameraOffCommand implements Command{
    private Device camera = new Camera();
    @Override
    public void execute() {
        camera.off();
    }
}
