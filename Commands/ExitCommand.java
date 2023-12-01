package Commands;

public class ExitCommand implements Command {
    public boolean execute() {
        System.exit(0);
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

    public String getInfo() {
        return null;
    }

}
