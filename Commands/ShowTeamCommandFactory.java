package Commands;

import Memento.*;

public class ShowTeamCommandFactory implements CommandFactory {
    private Caretaker com;

    public ShowTeamCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new ShowTeamCommand(com);
    }

}
