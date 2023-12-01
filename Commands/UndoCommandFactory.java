package Commands;

import Memento.*;

public class UndoCommandFactory implements CommandFactory {
    private Caretaker com;

    public UndoCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new UndoCommand(com);
    }

}
