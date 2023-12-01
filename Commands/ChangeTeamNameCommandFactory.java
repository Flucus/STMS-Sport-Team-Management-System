package Commands;

import Memento.*;

public class ChangeTeamNameCommandFactory implements CommandFactory {
    private Caretaker com;

    public ChangeTeamNameCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new ChangeTeamNameCommand(com);
    }
}
