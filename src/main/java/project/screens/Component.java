package project.screens;

public interface Component {
    void init();
    boolean isInitialized();
    void setInitialized(boolean initialized);
}