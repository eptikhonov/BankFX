import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccountOverviewController {

	@FXML private Button createCheckings;
	@FXML private Button createSavings;
	@FXML private Button deleteAccount;
	@FXML private Button deposit;
	@FXML private Button withdraw;
	@FXML private Button transfer;
	@FXML private GridPane accountsGridPane;
	@FXML private Text logOff;
	@FXML private Text welcomeUserText;

	static DecimalFormat decimalFormat = new DecimalFormat("#.00");
	private int maximumGridRows = 1;
	private int accountID;

	// key value pair array so you can delete by using ID
	static HashMap<Integer, BankAccount> bankAccountsHash = new HashMap<Integer, BankAccount>();

	BankAccount BankAccount;

	public void initialize() {
		welcomeUserText.setText("Welcome, "+LoginController.getUsername());

		createCheckings.setOnAction(actionEvent ->  {

			// if bankAccountsHash is empty, add it/replace it in that column
			// loop through to check empty, if empty ^

			if (maximumGridRows < 4) { //replace to size of the array
				accountID = generateAccountID() + (maximumGridRows * 1000);

				BankAccount acc = new BankAccount("Checkings", accountID, (1000 + Math.random() * 9000));
				bankAccountsHash.put(accountID, acc);
				accountsGridPane.add(acc.createAccountPane(), 0, maximumGridRows - 1);

			}

			maximumGridRows++;
		});

		createSavings.setOnAction(actionEvent ->  {

			if (maximumGridRows < 4) {
				accountID = generateAccountID() + (maximumGridRows * 1000);

				SavingsAccount acc = new SavingsAccount("Savings", accountID, (1000 + Math.random() * 9000), 0.01);
				bankAccountsHash.put(accountID, acc);
				accountsGridPane.add(acc.createAccountPane(), 0, maximumGridRows - 1);

			}

			maximumGridRows++;
		});

		deleteAccount.setOnAction(actionEvent ->  {
			// accountID from the accountsGridPane
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Delete Account");
			//dialog.setHeaderText("Are you sure you want to delete account "+accountID+"?");
			dialog.setContentText("Please confirm the account number:");

			Optional<String> input = dialog.showAndWait();
			if (input.isPresent()) {

				for (Iterator<Entry<Integer, BankAccount>> iterator = bankAccountsHash.entrySet().iterator(); iterator.hasNext();) {
					Entry<Integer, BankAccount> pair = iterator.next();
					if(input.get().equals(Integer.toString((int) pair.getKey()))) {
						iterator.remove();

						//pair.getValue().accountID = 123;
						//System.out.println("size: "+bankAccountsHash.size());

						bankAccountsHash.remove(pair.getKey());

						// get first integer of accountID (x / 1000) and - 1 for it's row to delete it
						int rowToDelete = ((int) pair.getKey() / 1000) - 1;

						accountsGridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == rowToDelete);

						//System.out.println("Account "+pair.getKey()+" closed.");
					}

				}

			}
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
		int accountID = (int) (100 + Math.random() * 900);

		// random 4 digit number and check if already created (save in SQL and check)
		return accountID;
	}

	// TODO: Make sure that no two AccountIds are the same
	// make a method to check that within the createCheckings and createSavings

	public GridPane getGridPane() {
		return accountsGridPane;
	}

	public static void transfer(int otherAccount, double transferAmount) {
		//pair.getValue().accountID = 123;
		for (Iterator<Entry<Integer, BankAccount>> iterator = bankAccountsHash.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, BankAccount> pair = iterator.next();
			if((int) pair.getKey() == otherAccount) {
				iterator.remove();

				pair.getValue().deposit(transferAmount);
				pair.getValue().setBalance(pair.getValue().accountBalance);

			}

		}
	}

}
