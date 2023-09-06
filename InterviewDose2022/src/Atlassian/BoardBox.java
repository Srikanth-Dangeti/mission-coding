package Atlassian;

public class BoardBox{

    /***
     *  00 -> boardbox
     *  01 ->
     *
     *
     */
    private final int row, column;
    private BoxType boxType;
    public BoardBox(int row, int column){
        this.row = row;
        this.column = column;
    }

    public void setBoxType (BoxType boxType){
        this.boxType = boxType;
    }

    public BoxType getBoxType(){
        return boxType;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }


}