package keepapp.view;

import javafx.application.Preloader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PreloadKeeper extends Preloader {
	private Stage stage;
	private ProgressIndicator progress;
	
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		Group root = new Group();
		root.setTranslateX(200);
		root.setTranslateY(200);
		Scene scene = new Scene(root, 800, 600);
		BorderPane pane = new BorderPane();
		pane.setPrefSize(200, 200);
		progress = new ProgressIndicator();
		pane.setCenter(progress);
		root.getChildren().addAll(pane);
		stage.setScene(scene);
		stage.show();
	}
}
