package Commands;

import Memento.*;

public class ModifyPlayerPositionCommandFactory implements CommandFactory {
    private Caretaker com;

    public ModifyPlayerPositionCommandFactory(Caretaker com) {
        this.com = com;
    }

    public Command createCommand() {
        return new ModifyPlayerPositionCommand(com);
    }

}
