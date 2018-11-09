import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccountOverviewController {

	@FXML private Button createCheckings;
	@FXML private Button createSavings;
	@FXML private Button deposit;
	@FXML private Button withdraw;
	@FXML private Button transfer;
	@FXML private GridPane accountsGridPane;
	@FXML private Text logOff;
	@FXML private Text welcomeUserText;

	private int maximumGridRows = 0;

	public void initialize() {
		welcomeUserText.setText("Welcome, "+LoginController.getUsername());
		
		createCheckings.setOnAction(actionEvent ->  {
			if (maximumGridRows < 3) {
				BankAccount acc = new BankAccount("Checkings", generateAccountID(), (1000 + Math.random() * 9000));
				accountsGridPane.add(acc.createAccountPane(), 0, maximumGridRows);
			}

			maximumGridRows++;
		});

		createSavings.setOnAction(actionEvent ->  {
			if (maximumGridRows < 3) {
				SavingsAccount acc = new SavingsAccount("Savings", generateAccountID(), (1000 + Math.random() * 9000), 0.01);
				accountsGridPane.add(acc.createAccountPane(), 0, maximumGridRows);
			}

			maximumGridRows++;
		});

		logOff.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent actionEvent) {
				// go to login scene
				try {
					Parent LoginParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
					Scene LoginScene = new Scene(LoginParent);
					Stage LoginStage = (Stage)  ((Node) actionEvent.getSource()).getScene().getWindow();
					LoginStage.setScene(LoginScene);
					LoginStage.show();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	// generate random account ID
	public int generateAccountID() {
		int accountID = (int) (1000 + Math.random() * 9000);

		// random 4 digit number and check if already created (save in SQL and check)
		return accountID;
	}
}
