public class Memento {
    private GameEngineData state;

    public Memento(GameEngineData state){
        this.state = state;
    }

    public GameEngineData getState(){
        return state;
    }
}
