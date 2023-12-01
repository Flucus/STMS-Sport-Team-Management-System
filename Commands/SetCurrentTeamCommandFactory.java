package Commands;

import Memento.*;

public class SetCurrentTeamCommandFactory implements CommandFactory {
    private Caretaker com;

    public SetCurrentTeamCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new SetCurrentTeamCommand(com);
    }

}
