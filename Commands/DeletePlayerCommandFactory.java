package Commands;

import Memento.*;

public class DeletePlayerCommandFactory implements CommandFactory {
    private Caretaker com;

    public DeletePlayerCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new DeletePlayerCommand(com);
    }
}
