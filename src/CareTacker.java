import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CareTacker {
   private  Stack<Memento> undo = new Stack<>();
   private  Stack<Memento> redo = new Stack<>();



    public void addundo (Memento state){
        undo.push(state);
    }
    public void addredo (Memento state){
        redo.push(state);
    }

    public Memento getundo(){ return undo.pop(); }
    public Memento saveundo(){return undo.peek();}
    public Memento getredo(){
        return undo.pop();
    }



}
