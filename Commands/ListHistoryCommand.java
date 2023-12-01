package Commands;

import Memento.*;

public class ListHistoryCommand implements Command {
    private Caretaker com;

    public ListHistoryCommand(Caretaker com) {
        this.com = com;
    }

    public boolean execute() {
        // Remove the most recent command from the history stack
        com.historyStack.pop();

        // Print all commands in the history stack
        System.out.println("Undo List");
        for (int i = 0; i < com.historyStack.size(); i++) {
            Command command = com.historyStack.get(i);
            System.out.println(command.getInfo());
        }
        System.out.println("-- End of undo list --");

        // Print all commands in the redo stack
        System.out.println("Redo List");
        for (int i = 0; i < com.redoStack.size(); i++) {
            Command command = com.redoStack.get(i);
            System.out.println(command.getInfo());
        }

        System.out.println("-- End of redo list --");
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

    public String getInfo() {
        return "ListHistoryCommand.getInfo()";
    }
}
