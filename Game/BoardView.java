package Game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class BoardView extends Application {
    private static final int GRID_SIZE = 5;
    private static final String EMPTY = " ";
    static GridPane gridPane = new GridPane();
    String[][] board = new String[GRID_SIZE][GRID_SIZE];
    int countOH = 0;
    int countOV = 0;
    int countOD1 = 0;
    int countOD2 = 0;

    int countXH = 0;
    int countXV = 0;
    int countXD1 = 0;
    int countXD2 = 0;


    private Button[][] buttons = new Button[GRID_SIZE][GRID_SIZE];
    private boolean xTurn = true;

    @Override
    public void start(Stage primaryStage) {

        //gridPane.setStyle("-fx-background-color: #FFE6E6E6;");

        gridPane.setAlignment(Pos.CENTER);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Button button = createButton();
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }




        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton() {
        Button button = new Button(EMPTY);
        button.setPrefSize(100, 100);
//        button.setStyle("-fx-background-color: #FFE6E6E6; -fx-border-width: 0;");
        button.setStyle("-fx-font-size: 30; -fx-background-color: transparent;");

        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1.5))));
        button.setOnAction(event -> {
            Button clickedButton = (Button) event.getSource();
            if (clickedButton.getText().equals(EMPTY)) {
                if (xTurn) {
                    button.setText("X");
//                    File imageFile = new File("Game/X.png");
//                    Image image = new Image(imageFile.toURI().toString());
//                    ImageView imageView = new ImageView(image);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    button.setGraphic(imageView);
                    addToarray();
                } else {
                    button.setText("O");
//                    File imageFile = new File("Game/O.png");
//                    Image image = new Image(imageFile.toURI().toString());
//                    ImageView imageView = new ImageView(image);
//                    imageView.setFitHeight(50);
//                    imageView.setFitWidth(50);
//                    button.setGraphic(imageView);
                    addToarray();
                }
                xTurn = !xTurn;
                clickedButton.setDisable(true);

                if(realSize(board) == (GRID_SIZE * GRID_SIZE) ){

                    System.out.println(checkWin());

                }
            }
        });
        return button;
    }

    private String checkWin() {


        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE - 2; j++) {
                if(board[i][j].equals(board[i][j + 1]) && board[i][j + 1].equals(board[i][j + 2]) && (board[i][j].equals("X") || board[i][j].equals("OX"))){
                    countXH++;
                    getButton(i,j).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i ,j + 1).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i ,j + 2).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");

                }
                if(board[i][j].equals(board[i][j + 1]) && board[i][j + 1].equals(board[i][j + 2]) && (board[i][j].equals("O") || board[i][j].equals("OX"))){
                    countOH++;
                    getButton(i,j).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i ,j+ 1).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i ,j + 2).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");

                }
            }}

        for(int j = 0; j<GRID_SIZE; j++){
            for (int i = 0; i < GRID_SIZE - 2; i++) {
                assert board[i] != null;
                if(board[i][j].equals(board[i+1][j]) && board[i +1][j].equals(board[i+2][j]) && (board[i][j].equals("X") || board[i][j].equals("OX")))
                {countXV++;
                    getButton(i,j).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 1,j).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 2,j).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");


                }
                if(board[i][j].equals(board[i+1][j]) && board[i +1][j].equals(board[i+2][j]) && (board[i][j].equals("O") || board[i][j].equals("OX"))) {
                    countOV++;
                    getButton(i,j).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 1,j).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 2,j).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");


                }
            }
        }

        for (int i = 0; i < GRID_SIZE - 2; i++) {
            for (int j = 0; j < GRID_SIZE -2; j++) {
                if(board[i][j].equals(board[i + 1][j + 1]) && board[i + 1][j + 1].equals(board[i + 2][j + 2]) && board[i][j].equals("X")){
                    countXD1++;
                    getButton(i,j).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 1,j + 1).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 2,j + 2).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");


                }
                if(board[i][j].equals(board[i + 1][j + 1]) && board[i + 1][j + 1].equals(board[i + 2][j + 2]) && board[i][j].equals("O")){
                    countOD1++;
                    getButton(i,j).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 1,j + 1).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 2,j + 2).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");


                }
            }
        }


        for (int i = 0; i < GRID_SIZE ; i++) {
            for (int j = 0; j< GRID_SIZE ; j++) {
            if(!outOfBoard(i + 1, j - 1) && !outOfBoard(i + 2, j - 2))    {
                if(board[i][j].equals(board[i + 1][j - 1]) && board[i + 1][j - 1].equals(board[i + 2][j - 2]) && board[i][j].equals("X"))
                {countXD2++;
                    getButton(i,j).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 1,j - 1).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 2,j - 2).setStyle("-fx-background-color: green; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");

                }
                if(board[i][j].equals(board[i + 1][j - 1]) && board[i + 1][j - 1].equals(board[i + 2][j - 2]) && board[i][j].equals("O"))
                {countOD2++;
                    getButton(i,j).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 1,j - 1).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                    getButton(i + 2,j - 2).setStyle("-fx-background-color: red; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-style: italic; -fx-font-size: 30px;");
                }
            }}
        }

        if(countXD1 + countXD2 + countXH + countXV > countOD1 + countOD2 + countOH + countOV)
            return "X Won with " + countXH + " Horizontal points, " + countXV + " Vertical points, and " + (countXD1 + countXD2) + " Diagonal points";
        if (countXD1 + countXD2 + countXH + countXV < countOD1 + countOD2 + countOH + countOV) {
            return "O Won with " + countOH + " Horizontal points, " + countOV + " Vertical points, and " + (countOD1 + countOD2) + " Diagonal points";
        }

        return "Draw with " + countOH + " Horizontal points, " + countOV + " Vertical points, and " + (countOD1 + countOD2) + " Diagonal points";
    }

    // old rule 4 in row and 5 in a row only count as one
//    public String countRow(String[] s){
//        for(int i = 0; i<s.length-2; i++){
//            if(s[i].equals(s[i + 1]) && s[i + 1].equals(s[i+2]))
//                return s[i];
//        }
//        return EMPTY;
//    }

   public int addHor(String[] s , String s1){
        int res = 0;
       for (int i = 0; i < s.length -2 ; i++) {
           if(s[i].equals(s[i + 1]) && s[i + 1].equals(s[i+2]) && s[i].equals(s1))
               res++;
       }
       return res;
   }

   public static boolean outOfBoard(int x, int y){
        return (x>(GRID_SIZE -1) || x<0 || y>(GRID_SIZE -1) || y < 0 );
   }



    private int realSize(String[][] board) {
        int res = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if(board[i][j].equals("X") || board[i][j].equals("O")){
                    res++;
                }
            }
        }
        return res;}

    public void addToarray(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                board[i][j] = getButton(i, j).getText();
            }
        }
    }

    public static Button getButton(int row, int col) {
        for (javafx.scene.Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col)
                return (Button) node;
        }
        return null;
    }

    public void printarray(String[][] s){
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.println();
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(s[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {launch(args);}
}
