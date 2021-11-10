package com.command.SmartHome;

public class SmartHome {
    private String name;
    private int serialNumber;
    private Adresse adresse;
    private RemoteControl remoteControl;

    public SmartHome() {
    }

    public RemoteControl getRemoteControl() {
        return remoteControl;
    }

    public void setRemoteControl(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    public String report() {
        return this.remoteControl.getReport();
    }
    public static class ConcretSmartHomeBuilder {
        private String name;
        private int serialNumber;
        private Adresse adresse;
        private RemoteControl remoteControl;

        public ConcretSmartHomeBuilder(String name, int serialNumber) {
            this.name = name;
            this.serialNumber = serialNumber;
        }

        public ConcretSmartHomeBuilder withAdresse(Adresse adresse) {
            this.adresse = adresse;
            return this;
        }
        public ConcretSmartHomeBuilder withRemoteControl(RemoteControl remoteControl) {
            this.remoteControl = remoteControl;
            return this;
        }
        public SmartHome build() {
            SmartHome smartHome = new SmartHome();
            smartHome.adresse = this.adresse;
            smartHome.remoteControl = this.remoteControl;
            return smartHome;
        }

    }

}
