import java.text.DecimalFormat;
import java.util.Optional;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
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

	Text accountDeleteText;

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
					// check for negative deposit amounts
					if (amountAsDouble < 0) {
						throw new IllegalArgumentException("Please enter a positive deposit amount");
					} else {
						accountBalance += amountAsDouble;
						// TODO: must update window or something (make a function)
						System.out.println("$"+amountAsDouble+" deposited into Account #"+accountID+".");
						System.out.println("Total balance: $"+accountBalance);
					}
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
					if (amountAsDouble < 0) {
						throw new IllegalArgumentException("Please enter a positive withdraw amount");
					} else {
						accountBalance -= amountAsDouble;
						// TODO: must update window or something (make a function)
						System.out.println("$"+amountAsDouble+" withdrawn from Account #"+accountID+".");
						System.out.println("Total balance: $"+accountBalance);
					}
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
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Transfer out of "+accountType+"("+accountID+")");
				dialog.setContentText("Enter other account number:");
				dialog.setContentText("Enter transfer amount:");

				Optional<String> amount = dialog.showAndWait();
				if (amount.isPresent()) {
					Double amountAsDouble = Double.valueOf(amount.get());
					// check for negative withdrawal amounts
					if (amountAsDouble < 0) {
						throw new IllegalArgumentException("Please enter a positive transfer amount");
					} else {
						accountBalance -= amountAsDouble;
						//otherAccount.deposit(amount);
						// TODO: must update window or something (make a function)
						System.out.println("$"+amountAsDouble+" transfered from Account #"+accountID+".");
						System.out.println("Total balance: $"+accountBalance);
					}
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

		Text accountBalanceText = new Text("$"+decimalFormat.format(accountBalance));
		accountBalanceText.setFill(Color.WHITE);
		accountBalanceText.setLayoutX(454.0);
		accountBalanceText.setLayoutY(34.0);
		accountBalanceText.setTextAlignment(TextAlignment.CENTER);
		accountBalanceText.setFont(Font.font ("Times New Roman", 20));

		// TODO: Make an X text to delete the account, a dialog pops up
		// that requires you to enter the accountID to confirm to delete
		accountDeleteText = new Text("X");
		accountDeleteText.setFill(Color.WHITE);
		accountDeleteText.setCursor(Cursor.HAND);
		accountDeleteText.setId("deleteAccountText");
		accountDeleteText.setLayoutX(560.0);
		accountDeleteText.setLayoutY(20.0);
		accountDeleteText.setTextAlignment(TextAlignment.CENTER);
		accountDeleteText.setFont(Font.font ("Arial", 20));

		this.deleteAccountClickListener();

		bankAccount.getChildren().addAll(
				backgroundRectangle,depositButton, withdrawButton, transferButton, accountTypeText, accountNumberText, accountBalanceText, accountDeleteText);

		return bankAccount;
	}

	public void deleteAccountClickListener() {
		accountDeleteText.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent actionEvent) {
				// remove entire row with confirmation
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Delete Account");
				dialog.setHeaderText("Are you sure you want to delete account "+accountID+"?");
				dialog.setContentText("Please confirm the account number:");

				Optional<String> input = dialog.showAndWait();
				if (input.isPresent()) {
					if (input.get().equals(Integer.toString(accountID))) {
						// delete that row
						System.out.println("Account "+accountID+" deleted.");
						// click from that row
					}
				}

			}
		});
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
