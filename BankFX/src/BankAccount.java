import java.text.DecimalFormat;
import javafx.scene.control.Button;
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
		depositButton.setPrefHeight(22.0);
		depositButton.setPrefWidth(159.0);
		depositButton.setLayoutX(34.333);
		depositButton.setLayoutY(45.0);

		Button withdrawButton = new Button();
		withdrawButton.setText("Withdraw");
		withdrawButton.setPrefHeight(22.0);
		withdrawButton.setPrefWidth(159.0);
		withdrawButton.setLayoutX(211.0);
		withdrawButton.setLayoutY(45.0);

		Button transferButton = new Button();
		transferButton.setText("Transfer");
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

		// Double.toString(accountBalance)
		Text accountBalanceText = new Text(decimalFormat.format(accountBalance));
		accountBalanceText.setFill(Color.WHITE);
		accountBalanceText.setLayoutX(454.0);
		accountBalanceText.setLayoutY(34.0);
		accountBalanceText.setTextAlignment(TextAlignment.CENTER);
		accountBalanceText.setFont(Font.font ("Times New Roman", 20));

		bankAccount.getChildren().addAll(backgroundRectangle,depositButton, withdrawButton, transferButton, accountTypeText, accountNumberText, accountBalanceText);

		return bankAccount;
	}

	// TODO: Create Dialog boxes for each action and make exceptions visible in GUI

	public void deposit(double amount) {
		// check for negative deposit amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive deposit amount");
		} else {
			accountBalance += amount;
		}
	}

	public void withdraw(double amount) {

		// check for negative withdraw amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive withdraw amount");
		} else {
			accountBalance -= amount;
		}
	}
	public double getBalance() {
		return accountBalance;
	}

	public void transfer(BankAccount otherAccount, double amount) {

		// check for negative transfer amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive transfer amount");
		} else {
			accountBalance -= amount;
			otherAccount.deposit(amount);
		}

	}

}
