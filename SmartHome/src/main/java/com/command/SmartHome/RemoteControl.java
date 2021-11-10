package com.command.SmartHome;

import com.command.SmartHome.Devices.Device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoteControl {
    private int nbrSlot;
    private List<Device> devices;
    private String report="";

    public RemoteControl(int nbrSlot) {
        this.nbrSlot = nbrSlot;
    }
    public void init(Device ...devices) {
        this.devices = new ArrayList<Device>(this.nbrSlot);
        Arrays.stream(devices)
                .forEach(device -> {
                    this.devices.add(device);
                });
    }

    public String getReport() {
        return report;
    }

    public void onButtonPressed(int indexDevice) {
        this.report += this.devices.get(indexDevice).on();
    }

    public void offButtonPressed(int indexDevice) {
        this.report += this.devices.get(indexDevice).off();
    }



}
