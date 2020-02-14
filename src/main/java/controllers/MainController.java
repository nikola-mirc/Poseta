package controllers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import dao.TeacherDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Teacher;
import utils.DBconnection;

public class MainController implements Initializable {

	@FXML
	private ComboBox<String> dayCombo;

	@FXML
	private ComboBox<String> classCombo;

	@FXML
	private JFXButton pickButton;

	@FXML
	private Button tableButton, infoButton;

	@FXML
	private Label resultLabel;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		DBconnection connection = new DBconnection();
	}

	@FXML
	void openTableManagement(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/management.fxml"));
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

	@FXML
	void randomDraw(ActionEvent event) {
		Random random = new Random();
		String day = dayCombo.getSelectionModel().getSelectedItem();
		String time = classCombo.getSelectionModel().getSelectedItem();

		ObservableList<Teacher> obsList = TeacherDAO.getListFromTable(day.toLowerCase().concat(time));

		if (obsList.size() == 0) {
			resultLabel.setText("Nema podataka");
		} else {
			Teacher selected = obsList.get(random.nextInt(obsList.size()));
			resultLabel.setText(selected.getName().concat(" ").concat(selected.getSurname()));
		}
	}

	@FXML
	void openInfo(ActionEvent event) {

	}

}
