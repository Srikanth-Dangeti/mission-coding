package Atlassian;

public class SnakeBoard {

    private int numberOfRows, numberOfColumns;

    private BoardBox[][] boardBoxes;

    public SnakeBoard(int numberOfRows, int numberOfColumns){
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        boardBoxes = new BoardBox[numberOfRows][numberOfColumns];

        for(int i =0;i<numberOfRows;i++){
            for(int j=0;j<numberOfColumns;j++){
                boardBoxes[i][j] = new BoardBox(i,j);
            }
        }

    }

    public BoardBox[][] getBoardBoxes() {
        return boardBoxes;
    }

    public void setBoardBoxes(BoardBox[][] boardBoxes) {
        this.boardBoxes = boardBoxes;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }
}
