package launcher;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
        root.getChildren().addAll(parent);
        primaryStage.getIcons().add(new Image(MainController.class.getResourceAsStream("/images/icon.png")));
        primaryStage.setTitle("Poseta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
