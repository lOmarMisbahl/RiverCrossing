public class Originator {
    private GameEngine state;

    public void setState(GameEngine state){
        this.state = state;
    }

    public GameEngine getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
