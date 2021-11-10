package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class MarioRightCommand implements Command {
    private MarioCharacterReceiver marioCharacter;

    public MarioRightCommand(MarioCharacterReceiver marioCharacter) {
        this.marioCharacter = marioCharacter;
    }

    @Override
    public void execute() {
        marioCharacter.moveRight();
    }
}
