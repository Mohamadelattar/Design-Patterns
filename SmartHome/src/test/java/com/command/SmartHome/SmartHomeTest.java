package com.command.SmartHome;

import org.junit.Test;
import static org.junit.Assert.*;

import com.command.SmartHome.Devices.Camera;
import com.command.SmartHome.Devices.Device;
import com.command.SmartHome.Devices.Tv;


public class SmartHomeTest {

    @Test
    public void report() {
        int nbrSlot=2;
        Adresse adresse = new Adresse(123,"agadir");
        Device tv =new Tv();
        Device camera = new Camera();
        RemoteControl remoteControl = new RemoteControl(nbrSlot);
        remoteControl.init(tv,camera);
        SmartHome smartHome = new SmartHome.ConcretSmartHomeBuilder("ny Homa",12345)
                .withAdresse(adresse)
                .withRemoteControl(remoteControl)
                .build();
        smartHome.getRemoteControl().onButtonPressed(0);
        smartHome.getRemoteControl().offButtonPressed(0);
        smartHome.getRemoteControl().onButtonPressed(1);
        smartHome.getRemoteControl().offButtonPressed(1);
        String expectedReport = "TV-On TV-Off Camera-On Camera-Off ";
        assertEquals(expectedReport,smartHome.report());
    }
}
