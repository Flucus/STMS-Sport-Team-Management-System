package Commands;

import Memento.*;

public class DisplayAllTeamCommandFactory implements CommandFactory {
    private Caretaker com;

    public DisplayAllTeamCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new DisplayAllTeamCommand(com);
    }

}
