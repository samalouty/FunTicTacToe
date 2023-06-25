package Game;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class BoardView extends Application {
    private static final int GRID_SIZE = 5;
    private static final String EMPTY = " ";

    private Button[][] buttons = new Button[GRID_SIZE][GRID_SIZE];
    private boolean xTurn = true;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();

        gridPane.setStyle("-fx-background-color: #FFE6E6E6;");

        gridPane.setAlignment(Pos.CENTER);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Button button = createButton();
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }

        Line vLine1 = new Line(100, 0, 100, 500);
        Line vLine2 = new Line(200, 0, 200, 500);
        Line vLine3 = new Line(300, 0, 300, 500);
        Line vLine4 = new Line(400, 0, 400, 500);

        Line hLine1 = new Line(0, 100, 500, 100);
        Line hLine2 = new Line(0, 200, 500, 200);
        Line hLine3 = new Line(0, 300, 500, 300);
        Line hLine4 = new Line(0, 400, 500, 400);


        borderPane.getChildren().addAll(vLine1, vLine2, vLine3, vLine4, hLine1, hLine2, hLine3, hLine4);



        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton() {
        Button button = new Button(EMPTY);
        button.setPrefSize(50, 50);
        button.setOnAction(event -> {
            Button clickedButton = (Button) event.getSource();
            if (clickedButton.getText().equals(EMPTY)) {
                if (xTurn) {
                    clickedButton.setText("X");
                } else {
                    clickedButton.setText("O");
                }
                xTurn = !xTurn;
                clickedButton.setDisable(true);

                // Call a method to check for a winner and update the game state
                // Implement this logic based on the Tic Tac Toe rules
            }
        });
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
