public class Save implements Command {
    private FilesParser Save = new FilesParser();

    @Override
    public void Execute() {
        Save.WriteSaveGame();
    }

}