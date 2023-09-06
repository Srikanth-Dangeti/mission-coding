package Atlassian;

import java.util.LinkedList;

public class Snake {

    private LinkedList<BoardBox> snakePartList = new LinkedList<>();

    private BoardBox snakeHead;

    private int countMoves = 0;


    public Snake(BoardBox snakeHead) {
        this.snakeHead = snakeHead;
        snakePartList.add(snakeHead);
        snakeHead.setBoxType(BoxType.snake_box);
    }

    public boolean contactCheck(BoardBox nextBoardBox){
        for(BoardBox box: snakePartList){
            if(nextBoardBox==box){
                return true;
            }
        }
        return false;
    }

    public void move(BoardBox nextBoardBox){
        if(countMoves<5) {
            BoardBox tailBoardBox = snakePartList.removeLast();
            tailBoardBox.setBoxType(BoxType.empty);

            snakeHead = nextBoardBox;
            snakeHead.setBoxType(BoxType.snake_box);
            snakePartList.addFirst(snakeHead);
            countMoves ++;
        }
        else{
            snakeHead = nextBoardBox;
            snakeHead.setBoxType(BoxType.snake_box);
            snakePartList.addFirst(snakeHead);
            countMoves=0;
        }


    }

    public LinkedList<BoardBox> getSnakePartList() {
        return snakePartList;
    }

    public void setSnakePartList(LinkedList<BoardBox> snakePartList) {
        this.snakePartList = snakePartList;
    }

    public BoardBox getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(BoardBox snakeHead) {
        this.snakeHead = snakeHead;
    }
}
