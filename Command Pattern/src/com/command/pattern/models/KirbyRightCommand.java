package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class KirbyRightCommand implements Command {
    private KirbyCharacterReceiver kirbyCharacterReceiver;

    public KirbyRightCommand(KirbyCharacterReceiver kirbyCharacterReceiver) {
        this.kirbyCharacterReceiver = kirbyCharacterReceiver;
    }

    @Override
    public void execute() {
        kirbyCharacterReceiver.moveRight();
    }
}
