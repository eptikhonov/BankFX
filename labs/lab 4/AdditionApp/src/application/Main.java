package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Addition App");

		// two text fields
        TextField first_number = new TextField();
        first_number.setMaxWidth(100.0);
        first_number.setPromptText("First number");
        first_number.setCenterShape(true);
        
        TextField second_number = new TextField();
        second_number.setMaxWidth(100.0);
        second_number.setPromptText("Second number");
        
        // label for showing the result
        Label result_lbl = new Label();
        result_lbl.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(result_lbl, 0.0);
        AnchorPane.setRightAnchor(result_lbl, 0.0);
        result_lbl.setAlignment(Pos.CENTER);
        result_lbl.setFont(Font.font(STYLESHEET_MODENA, 30));
        
        // calculation button
        Button calculate_btn = new Button("calculate");
        calculate_btn.setMaxWidth(Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(calculate_btn, 0.0);
        AnchorPane.setRightAnchor(calculate_btn, 0.0);
        calculate_btn.setAlignment(Pos.CENTER);

        // on button clicked, get textFields inputs and set result label as the answer of the addition of the two inputs
        calculate_btn.setOnAction(action -> {
        	int answer = 0, num1 = 0, num2 = 0;
        	
        	if (first_number.getText().equals("") | second_number.getText().equals("")) {
        		throw new IllegalArgumentException("Please enter some numbers");
        	} else {
        		num1 = Integer.parseInt(first_number.getText());
                num2 = Integer.parseInt(second_number.getText());
                answer = num1 + num2;
        	}
            
            result_lbl.setText(Integer.toString(answer)); // setting label to the answer
        });
        
        GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(15); // set vertical gap to 15
        grid.setHgap(12); // set horizontal gap to 12
        grid.add(first_number, 0, 1);
        grid.add(second_number, 0, 2);
        grid.add(calculate_btn, 0, 3);
        grid.add(result_lbl, 0, 4);
        
        Scene scene = new Scene(grid, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
