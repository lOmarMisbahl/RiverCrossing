public class Originator {
    private GameEngineData state;

    public void setState(GameEngineData state){
        this.state = state;
    }

    public GameEngineData getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
