package Commands;

import Memento.*;

public class AddPlayerCommandFactory implements CommandFactory {
    private Caretaker com;

    public AddPlayerCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new AddPlayerCommand(com);
    }

}
