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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class BoardView extends Application {
    private static final int GRID_SIZE = 5;
    private static final String EMPTY = " ";
    static GridPane gridPane = new GridPane();
    String[][] board = new String[5][5];


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
        button.setStyle("-fx-font-size: 0; -fx-background-color: transparent;");

        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1.5))));
        button.setOnAction(event -> {
            Button clickedButton = (Button) event.getSource();
            if (clickedButton.getText().equals(EMPTY)) {
                if (xTurn) {
                    button.setText("X");
                    File imageFile = new File("Game/X.png");
                    Image image = new Image(imageFile.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    button.setGraphic(imageView);
                    addToarray();
                } else {
                    button.setText("O");
                    File imageFile = new File("Game/O.png");
                    Image image = new Image(imageFile.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                    button.setGraphic(imageView);
                    addToarray();
                }
                xTurn = !xTurn;
                clickedButton.setDisable(true);

                // Count the number of three-in-a-rows each player has. Sequences can be vertically, horizontally, or diagonally. Whoever has the most, wins.
                if(realSize(board) == 24){
                   //write winner code here
                }
            }
        });
        return button;
    }



    private int realSize(String[][] board) {
        int res = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(board[i][j].equals("X") || board[i][j].equals("O")){
                    res++;
                }
            }
        }
        return res;}

    public void addToarray(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
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
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.print(s[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
