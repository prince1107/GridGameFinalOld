package com.example.gridgamefinal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.DoubleToIntFunction;

public class HelloController {
    @FXML GridPane gpane;
    private ArrayList<Player> currentPlayers = new ArrayList<>();
    private BoardSquare[][] board = new BoardSquare[15][15];
    private ImageView[][] boardImages = new ImageView[15][15];

    @FXML
    private ImageView b00,b01,b02,b03,b10,b11,b12,b13,b20,b21,b22,b23,b30,b31,b32,b33;
    private String[] boardSquareNames = {"b1", "b2", "b3", "b4", "r1", "r2", "r3", "r4","unowned"};
    private  int playerTurn=0;
    Image c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,green,yellow,blue,red,d2,d3,d4,d5;
    public HelloController(){
        FileInputStream cc2,cc3,cc4,cc5,cc6,cc7,cc8,cc9,cc10,cc11,cc12,cc13,greenn,yelloww,bluee,redd,dd2,dd3,dd4,dd5;
        try {
            bluee = new FileInputStream("src/main/Pictures/blue.png");
            blue = new Image(bluee);
            redd= new FileInputStream("src/main/Pictures/red.png");
            red = new Image(redd);
            greenn = new FileInputStream("src/main/Pictures/green.png");
            green = new Image(greenn);
            yelloww = new FileInputStream("src/main/Pictures/yellow.png");
            yellow = new Image(yelloww);
            cc2 = new FileInputStream("src/main/Pictures/C2.jpg");
            c2 = new Image(cc2);
            cc3 = new FileInputStream("src/main/Pictures/C3.jpg");
            c3 = new Image(cc3);
            cc4 = new FileInputStream("src/main/Pictures/C4.jpg");
            c4 = new Image(cc4);
            cc5 = new FileInputStream("src/main/Pictures/C5.jpg");
            c5 = new Image(cc5);
            cc6 = new FileInputStream("src/main/Pictures/C6.jpg");
            c6 = new Image(cc6);
            cc7 = new FileInputStream("src/main/Pictures/C7.jpg");
            c7 = new Image(cc7);
            cc8 = new FileInputStream("src/main/Pictures/C8.jpg");
            c8 = new Image(cc8);
            cc9 = new FileInputStream("src/main/Pictures/C9.jpg");
            c9 = new Image(cc9);
            cc10 = new FileInputStream("src/main/Pictures/C10.jpg");
            c10 = new Image(cc10);
            cc11 = new FileInputStream("src/main/Pictures/C11.jpg");
            c11 = new Image(cc11);
            cc12 = new FileInputStream("src/main/Pictures/C12.jpg");
            c12 = new Image(cc12);
            cc13 = new FileInputStream("src/main/Pictures/C13.jpg");
            c13 = new Image(cc13);
            dd2 = new FileInputStream("src/main/Pictures/D2.jpg");
            d2 = new Image(dd2);
            dd3 = new FileInputStream("src/main/Pictures/D3.jpg");
            d3 = new Image(dd3);
            dd4 = new FileInputStream("src/main/Pictures/D4.jpg");
            d4 = new Image(dd4);
            dd5 = new FileInputStream("src/main/Pictures/D5.jpg");
            d5 = new Image(dd5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //board pieces
        board[0][0] = new BoardSquare(0,0,boardSquareNames[0],c2,0,2);
        board[0][1] = new BoardSquare(0,1,boardSquareNames[1],c3,0,3);
        board[0][2] = new BoardSquare(0,2,boardSquareNames[2],c4,0,4);
        board[0][3] = new BoardSquare(0,3,boardSquareNames[3],c5,0,5);
        board[0][4] = new BoardSquare(0,0,boardSquareNames[0],c2,0,2);
        board[0][5] = new BoardSquare(0,1,boardSquareNames[1],c3,0,3);
        board[0][6] = new BoardSquare(0,2,boardSquareNames[2],c4,0,4);
        board[0][7] = new BoardSquare(0,3,boardSquareNames[3],c5,0,5);

        board[3][0] = new BoardSquare(3,0,boardSquareNames[4],d2,1,2);
        board[3][1] = new BoardSquare(3,1,boardSquareNames[5],d3,1,3);
        board[3][2] = new BoardSquare(3,2,boardSquareNames[6],d4,1,4);
        board[3][3] = new BoardSquare(3,3,boardSquareNames[7],d5,1,5);

        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = new BoardSquare(i,j,boardSquareNames[8],yellow,2,0);
            }
        }
        currentPlayers.add(new Player("player 1"));
        currentPlayers.add(new Player("Player 2"));
        for (int i = 0; i < 4; i++) {
            currentPlayers.get(0).setOwned(board[0][i]);
        }
        for (int i = 0; i < 4; i++) {
            currentPlayers.get(1).setOwned(board[3][i]);
        }



    }
    @FXML
    protected void handleStart(ActionEvent event){
        boardImages[0][0]=b00;boardImages[0][1]=b01;boardImages[0][2]=b02;boardImages[0][3]=b03;
        boardImages[1][0]=b10;boardImages[1][1]=b11;boardImages[1][2]=b12;boardImages[1][3]=b13;
        boardImages[2][0]=b20;boardImages[2][1]=b21;boardImages[2][2]=b22;boardImages[2][3]=b23;
        boardImages[3][0]=b30;boardImages[3][1]=b31;boardImages[3][2]=b32;boardImages[3][3]=b33;

        for (int i = 0; i <boardImages.length; i++) {
            for (int j = 0; j < boardImages.length; j++) {
                boardImages[i][j].setImage(board[i][j].getImage());
            }
        }

    }
    ImageView firstClick;
    ImageView secondClick;
    int click1X,click2X,click1Y,click2Y;
    @FXML
    private void handleClickImage(MouseEvent event) {
        System.out.println(event);
        if(firstClick == null){
////            click1X = GridPane.getRowIndex(((ImageView) event.getSource()));
            firstClick = (ImageView) (event.getSource());
//            System.out.println(firstClick);
            click1X = GridPane.getRowIndex(firstClick);
            click1Y = GridPane.getColumnIndex(firstClick);
//            int imgClicked = GridPane.getColumnIndex((ImageView) event.getSource());
//            System.out.println(imgClicked);

        }else{
            secondClick = (ImageView) (event.getSource());
            click2X = GridPane.getRowIndex(secondClick);
            click2Y = GridPane.getColumnIndex(secondClick);
            checkResult();
            firstClick =null;
            secondClick = null;
        }

    }
    public void checkResult(){
        BoardSquare first = board[click1X][click1Y];
        BoardSquare second =board[click2X][click2Y];
        if (first.getPower()>second.getPower()){
            first.changeLocation(click2X,click2Y);
            board[click1X][click1Y]=new BoardSquare(click1X,click1Y,boardSquareNames[8],yellow,2,0);
            board[click2X][click2Y] = first;
            boardImages[click1X][click1Y].setImage(yellow);
            boardImages[click2X][click2Y].setImage(first.getImage());
        }else{
            currentPlayers.get(0).removeFromOwned(first);
            boardImages[click1X][click1Y].setImage(yellow);
            board[click1X][click1Y]=new BoardSquare(click1X,click1Y,boardSquareNames[8],yellow,2,0);
        }
    }

}