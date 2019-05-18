import java.text.DecimalFormat;
import java.util.Optional;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class BankAccount {

	DecimalFormat decimalFormat = new DecimalFormat("#.00"); 

	protected double accountBalance;
	protected int accountID;
	protected String accountType;
	protected Text accountBalanceText;

	public BankAccount(String accountType, int accountID, double accountBalance) {

		this.accountType = accountType;
		this.accountID = accountID;
		this.accountBalance = accountBalance;
	}

	Pane createAccountPane() {
		Pane bankAccount = new Pane();
		bankAccount.setPrefWidth(200);
		bankAccount.setPrefHeight(200);

		Rectangle backgroundRectangle = new Rectangle();
		backgroundRectangle.setHeight(78.0);
		backgroundRectangle.setWidth(580.0);
		backgroundRectangle.setArcHeight(20.0);
		backgroundRectangle.setArcWidth(20.0);
		backgroundRectangle.setFill(Color.GRAY);

		Button depositButton = new Button();
		depositButton.setText("Deposit");
		depositButton.setCursor(Cursor.HAND);

		depositButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent actionEvent) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Deposit into "+accountType+"("+accountID+")");
				dialog.setContentText("Enter deposit amount:");

				Optional<String> amount = dialog.showAndWait();
				if (amount.isPresent()) {
					Double amountAsDouble = Double.valueOf(amount.get());

					deposit(amountAsDouble);
				}
			}
		});

		depositButton.setPrefHeight(22.0);
		depositButton.setPrefWidth(159.0);
		depositButton.setLayoutX(34.333);
		depositButton.setLayoutY(45.0);

		Button withdrawButton = new Button();
		withdrawButton.setText("Withdraw");
		withdrawButton.setCursor(Cursor.HAND);

		withdrawButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent actionEvent) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Withdraw out of "+accountType+"("+accountID+")");
				dialog.setContentText("Enter withdrawal amount:");

				Optional<String> amount = dialog.showAndWait();
				if (amount.isPresent()) {
					Double amountAsDouble = Double.valueOf(amount.get());
					// check for negative withdrawal amounts
					withdraw(amountAsDouble);
				}
			}
		});

		withdrawButton.setPrefHeight(22.0);
		withdrawButton.setPrefWidth(159.0);
		withdrawButton.setLayoutX(211.0);
		withdrawButton.setLayoutY(45.0);

		Button transferButton = new Button();
		transferButton.setText("Transfer");
		transferButton.setCursor(Cursor.HAND);

		// TODO: Implement getting account number to transfer and fix getting account # from dialog
		transferButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent actionEvent) {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("Transfer out of "+accountType+"("+accountID+")");
				dialog.setHeaderText("Transfer money!!!!!");

				Label otherAccountLabel = new Label("Enter other account number: ");
				Label transferAmountLabel = new Label("Enter transfer amount: ");
				TextField otherAccountTextField = new TextField();
				TextField transferAmountTextField = new TextField();

				GridPane grid = new GridPane();
				grid.add(otherAccountLabel, 1, 1);
				grid.add(otherAccountTextField, 2, 1);
				grid.add(transferAmountLabel, 1, 2);
				grid.add(transferAmountTextField, 2, 2);
				dialog.getDialogPane().setContent(grid);

				ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

				Optional<String> result = dialog.showAndWait();

				if (result.isPresent()) {

					int otherAccountAsInt = Integer.valueOf(otherAccountTextField.getText());
					double amountAsDouble = Double.valueOf(transferAmountTextField.getText());

					// check for negative transfer amounts
					if (amountAsDouble < 0) {
						throw new IllegalArgumentException("Please enter a positive transfer amount");
						// don't transfer money more than current balance
					} else if (amountAsDouble > accountBalance) {
						throw new IllegalArgumentException("Please enter a transfer amount smaller than current balance");
						// don't transfer if other account number is same other account number
					} else if (accountID == otherAccountAsInt) { 
						throw new IllegalArgumentException("Cannot transfer to self account");
					} else {
						accountBalance -= amountAsDouble;
						accountBalanceText.setText("$"+decimalFormat.format(accountBalance));

					}

					AccountOverviewController.transfer(otherAccountAsInt, amountAsDouble);

				}
			}
		});

		transferButton.setPrefHeight(22.0);
		transferButton.setPrefWidth(159.0);
		transferButton.setLayoutX(387.667);
		transferButton.setLayoutY(45.0);

		Text accountTypeText = new Text();
		accountTypeText.setText(accountType);
		accountTypeText.setFill(Color.WHITE);
		accountTypeText.setLayoutX(14.0);
		accountTypeText.setLayoutY(34.0);
		accountTypeText.setTextAlignment(TextAlignment.CENTER);
		accountTypeText.setFont(Font.font ("Times New Roman", 20));
		//accountTypeText.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20)); 

		Text accountNumberText = new Text("..."+accountID);
		accountNumberText.setFill(Color.WHITE);
		accountNumberText.setLayoutX(113.0);
		accountNumberText.setLayoutY(34.0);
		accountNumberText.setTextAlignment(TextAlignment.CENTER);
		accountNumberText.setFont(Font.font ("Times New Roman", 20));

		accountBalanceText = new Text("$"+decimalFormat.format(accountBalance));
		accountBalanceText.setFill(Color.WHITE);
		accountBalanceText.setLayoutX(454.0);
		accountBalanceText.setLayoutY(34.0);
		accountBalanceText.setTextAlignment(TextAlignment.CENTER);
		accountBalanceText.setFont(Font.font ("Times New Roman", 20));

		bankAccount.getChildren().addAll(
				backgroundRectangle,depositButton, withdrawButton, transferButton, accountTypeText, accountNumberText, accountBalanceText);

		return bankAccount;
	}

	public void deposit(double amount) {
		// check for negative deposit amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive deposit amount");
		} else {
			accountBalance += amount;
			accountBalanceText.setText("$"+decimalFormat.format(accountBalance));
			//System.out.println("$"+amountAsDouble+" deposited into Account #"+accountID+".");
			//System.out.println("Total balance: $"+accountBalance);
		}
	}

	// TODO: cannot withdraw more than you have
	public void withdraw(double amount) {

		// check for negative withdraw amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive withdraw amount");
		} else {
			accountBalance -= amount;
			accountBalanceText.setText("$"+decimalFormat.format(accountBalance));

		}
	}

	public double getBalance() {
		return accountBalance;
	}

	public void setBalance(double accountBalance) {
		accountBalanceText.setText("$"+decimalFormat.format(accountBalance));
	}
}
