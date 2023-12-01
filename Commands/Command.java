package Commands;

public interface Command {
    public boolean execute();

    public void undo();

    public void redo();

    public String getInfo();

}
