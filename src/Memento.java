public class Memento {
    private GameEngine state;

    public Memento(GameEngine state){
        this.state = state;
    }

    public GameEngine getState(){
        return state;
    }
}
