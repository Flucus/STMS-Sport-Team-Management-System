package Commands;

import Memento.*;

public class RedoCommandFactory implements CommandFactory {
    private Caretaker com;

    public RedoCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new RedoCommand(com);
    }

}
