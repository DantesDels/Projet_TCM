package core;

public interface Command {
    String getLabel();
    void execute();
}
