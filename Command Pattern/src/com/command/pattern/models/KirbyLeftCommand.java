package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class KirbyLeftCommand implements Command {
    private  KirbyCharacterReceiver kirbyCharacterReceiver;

    public KirbyLeftCommand(KirbyCharacterReceiver kirbyCharacterReceiver) {
        this.kirbyCharacterReceiver = kirbyCharacterReceiver;
    }

    @Override
    public void execute() {
        kirbyCharacterReceiver.moveLeft();
    }
}
