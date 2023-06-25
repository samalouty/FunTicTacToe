package Game;

public class Logic {
    public char[][] xoBoard = new char[5][5];
    private int turn = 0;

    public boolean xTurn(){
        return  turn %2 == 0;
    }

    public boolean yturn(){
        return !xTurn();
    }

    public void add(){
        turn++;
    }


}
