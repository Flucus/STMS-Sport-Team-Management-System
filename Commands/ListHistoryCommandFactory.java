package Commands;

import Memento.*;

public class ListHistoryCommandFactory implements CommandFactory{
    private Caretaker com;

    public ListHistoryCommandFactory(Caretaker com) {
        this.com = com;
    }

    public ListHistoryCommand createCommand() {
        return new ListHistoryCommand(com);
    }
    
}
