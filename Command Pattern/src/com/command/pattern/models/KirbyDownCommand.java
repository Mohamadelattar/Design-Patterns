package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class KirbyDownCommand implements Command {
    private KirbyCharacterReceiver kirbyCharacter;

    public KirbyDownCommand(KirbyCharacterReceiver kirbyCharacter) {
        this.kirbyCharacter = kirbyCharacter;
    }

    @Override
    public void execute() {
        kirbyCharacter.moveDown();
    }
}
