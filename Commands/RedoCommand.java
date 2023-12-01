package Commands;

import Memento.*;
import Teams.*;

public class RedoCommand implements Command {
    private Caretaker com;

    public RedoCommand(Caretaker com) {
        this.com = com;
    }

    public boolean execute() {
        com.historyStack.pop();

        if (com.redoStack.isEmpty()) {
            System.out.println("No command to redo");
            return false;
        }

        Team cTeam = com.currentTeam;
        Command command = com.redoStack.pop();
        com.historyStack.push(command);
        command.redo();

        System.out.println("Command (" + command.getInfo() + ") is redone.");

        if (cTeam != null && cTeam != com.currentTeam) {
            System.out.println("The current team is changed to " + com.currentTeam.getTeamID());
        }
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

    public String getInfo() {
        return "RedoCommand.getInfo()";
    }

}
