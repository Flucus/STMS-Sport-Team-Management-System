package Commands;

import Memento.*;
import Teams.*;

public class UndoCommand implements Command {
    private Caretaker com;

    public UndoCommand(Caretaker com) {
        this.com = com;
    }

    public boolean execute() {
        com.historyStack.pop();
        if (com.historyStack.isEmpty()) {
            System.out.println("No more commands to undo");
            return false;
        }

        Team cTeam = com.currentTeam;
        Command command = com.historyStack.pop();
        com.redoStack.push(command);
        command.undo();

        System.out.println("Command (" + command.getInfo() + ") is undone.");
        if (cTeam != null && cTeam != com.currentTeam) {
            System.out.println("The current team is changed to " + com.currentTeam.getTeamID() + " "
                    + com.currentTeam.getName() + ".");
        }
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

    public String getInfo() {
        return "UndoCommand.getInfo()";
    }

}
