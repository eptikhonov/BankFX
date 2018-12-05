import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import java.sql.*;

public class LoginController {

	@FXML private AnchorPane root;
	@FXML private TextField username_txtfld;
	@FXML private PasswordField password_txtfld;
	@FXML private Button login_btn;
	@FXML private Button register_btn;
	@FXML private Text displayError_txt;

	public static String username;
	// called by FXMLLoader to initialize the controller
	public void initialize() {

		// if login clicked, check username & password match SQL database, go to Account Overview.
		// else, display error
		login_btn.setOnAction(actionEvent ->  {

			if (username_txtfld.getText().equals("LilRob") && password_txtfld.getText().equals("pass")) {

				// go to next scene
				try {
					this.setUsername(username_txtfld.getText().toUpperCase());

					Parent accountOverviewParent = FXMLLoader.load(getClass().getResource("AccountOverview.fxml"));
					Scene accountOverviewScene = new Scene(accountOverviewParent);
					Stage accountOverviewStage = (Stage)  ((Node) actionEvent.getSource()).getScene().getWindow();
					accountOverviewStage.setScene(accountOverviewScene);
					accountOverviewStage.show();

				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				displayError_txt.setText("Invalid username or password");
			}


		});

		// if register button clicked, add username & password to SQL database (if username doesn't exist)
		// else, display error
		register_btn.setOnAction(actionEvent ->  {

		});
	}

	public void setUsername(String name) {
		username = name;
	}

	public static String getUsername() {
		return username;
	}

}
