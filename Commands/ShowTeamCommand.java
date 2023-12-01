package Commands;

import Memento.*;

public class ShowTeamCommand implements Command {
    private Caretaker com;

    public ShowTeamCommand(Caretaker com) {
        this.com = com;
    }

    public boolean execute() {
        com.historyStack.pop();
        com.currentTeam.displayTeam();
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

    public String getInfo() {
        return "ShowTeamCommand.getInfo()";
    }

}
