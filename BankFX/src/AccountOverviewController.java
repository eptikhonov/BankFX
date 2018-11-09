import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class AccountOverviewController {

	@FXML private Button createCheckings;
	@FXML private Button createSavings;
	@FXML private Button deposit;
	@FXML private Button withdraw;
	@FXML private Button transfer;
	@FXML private GridPane accountsGridPane;


	private int maximumGridRows = 0;

	public void initialize() {

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
	}

	// generate random account ID
	public int generateAccountID() {
		int accountID = (int) (1000 + Math.random() * 9000);

		// random 4 digit number and check if already created (save in SQL and check)
		return accountID;
	}
}
