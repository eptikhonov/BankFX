import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = 
				FXMLLoader.load(getClass().getResource("Login.fxml"));

		Platform.runLater( () -> root.requestFocus() );

		Scene scene = new Scene(root);
		stage.setTitle("BankFX");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		//SQLiteJDBCDriverConnection sql = new SQLiteJDBCDriverConnection();
		//sql.connect();
		
		launch(args); 
	}
}