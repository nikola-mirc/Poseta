package view;

import controllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUIutils {

	public static void loadFXML(Modality modality, String resourcePath) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getClassLoader().getResource(resourcePath));
			Parent parent = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.getIcons().add(new Image(MainController.class.getResourceAsStream("/images/icon.png")));
			stage.setTitle("Poseta");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
