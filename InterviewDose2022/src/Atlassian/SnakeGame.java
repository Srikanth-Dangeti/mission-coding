package Atlassian;

public class SnakeGame {
    public static char upDirection='u', downDirection='d',leftDirection = 'l',rightDirection = 'r';

    private Snake snake;
    private SnakeBoard snakeBoard;

    public char getInputDirection() {
        return inputDirection;
    }

    public void setInputDirection(char inputDirection) {
        this.inputDirection = inputDirection;
    }

    private char inputDirection;

    private Boolean isGameOver = false;


    public SnakeGame(Snake snake, SnakeBoard snakeBoard){
        this.snake = snake;
        this.snakeBoard = snakeBoard;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public SnakeBoard getSnakeBoard() {
        return snakeBoard;
    }

    public void setSnakeBoard(SnakeBoard snakeBoard) {
        this.snakeBoard = snakeBoard;
    }


    private BoardBox getNextBoardBox(BoardBox currentBox){
        int row = currentBox.getRow();
        int column = currentBox.getColumn();

        if(inputDirection==upDirection){
            row--;
        }
        else if(inputDirection == downDirection){
            row++;
        }
        else if(inputDirection == leftDirection){
            column--;
        }
        else if(inputDirection == rightDirection){
            column++;
        }

        if(row<0||row> snakeBoard.getNumberOfRows()||column<0||column> snakeBoard.getNumberOfColumns()){
            isGameOver = true;
            return new BoardBox(0,0);
        }
        else
        {
            return snakeBoard.getBoardBoxes()[row][column];
        }
    }



    public void updateGame(){

        if(!isGameOver){

            if(inputDirection=='u'||inputDirection=='d'||inputDirection=='r'||inputDirection=='l'){
                BoardBox nextBox = getNextBoardBox(snake.getSnakeHead());
                if(isGameOver){
                    System.out.println("Game Over");
                }
                if(snake.contactCheck(nextBox)){
                    isGameOver = true;
                }
                else{
                    snake.move(nextBox);
                }
            }
        }

    }

}
