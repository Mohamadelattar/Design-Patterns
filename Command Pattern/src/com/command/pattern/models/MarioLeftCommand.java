package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class MarioLeftCommand implements Command {
    private  MarioCharacterReceiver marioCharacterReceiver;

    public MarioLeftCommand(MarioCharacterReceiver marioCharacterReceiver) {
        this.marioCharacterReceiver = marioCharacterReceiver;
    }

    @Override
    public void execute() {
        marioCharacterReceiver.moveLeft();
    }
}
