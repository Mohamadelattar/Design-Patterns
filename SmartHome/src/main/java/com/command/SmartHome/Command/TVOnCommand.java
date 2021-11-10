package com.command.SmartHome.Command;

import com.command.SmartHome.Devices.Device;
import com.command.SmartHome.Devices.Tv;

public class TVOnCommand implements Command{
    private Device tv = new Tv();
    @Override
    public void execute() {
        tv.on();
    }
}
