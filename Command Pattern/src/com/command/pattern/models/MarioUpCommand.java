package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class MarioUpCommand implements Command {
    private MarioCharacterReceiver marioCharacter;

    public MarioUpCommand(MarioCharacterReceiver marioCharacter) {
        this.marioCharacter = marioCharacter;
    }

    @Override
    public void execute() {
        marioCharacter.moveUp();
    }
}
