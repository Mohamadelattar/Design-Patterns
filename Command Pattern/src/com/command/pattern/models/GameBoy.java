package com.command.pattern.models;

import com.command.pattern.interfaces.Command;

public class GameBoy {
    private Command UpCommand, DownCommand , LeftCommand , RightCommand;

    public GameBoy(Command upCommand, Command downCommand, Command leftCommand, Command rightCommand) {
        UpCommand = upCommand;
        DownCommand = downCommand;
        LeftCommand = leftCommand;
        RightCommand = rightCommand;
    }

    public void arrowUp() {
        UpCommand.execute();
    }

    public void arrowDown() {
        DownCommand.execute();
    }

    public void arrowRight() {
        RightCommand.execute();
    }

    public void arrowLeft() {
        LeftCommand.execute();
    }
}
