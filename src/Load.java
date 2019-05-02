public class Load implements Command {
    private FilesParser Load = new FilesParser();

    @Override
    public void Execute() {
        Load.ReadSaveGame();
    }
}
