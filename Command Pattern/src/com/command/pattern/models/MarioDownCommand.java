package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class MarioDownCommand implements Command {
    private MarioCharacterReceiver marioCharacter;

    public MarioDownCommand(MarioCharacterReceiver marioCharacter) {
        this.marioCharacter = marioCharacter;
    }

    @Override
    public void execute() {
        marioCharacter.moveDown();
    }
}
