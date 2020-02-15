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
import view.GUIutils;

public class MainController extends GUIutils implements Initializable {

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
	void randomDraw(ActionEvent event) {
		Random random = new Random();
		String selectedDay = dayCombo.getSelectionModel().getSelectedItem();
		String selectedClass = classCombo.getSelectionModel().getSelectedItem();

		if (selectedDay != null && selectedClass != null) {
			if (selectedDay.equals("Četvrtak")) {
				selectedDay = "Cetvrtak";
			}
			ObservableList<Teacher> obsList = TeacherDAO
					.getListFromTable(selectedDay.toLowerCase().concat(selectedClass));
			if (obsList.size() == 0) {
				resultLabel.setText("Nema podataka");
			} else {
				Teacher selected = obsList.get(random.nextInt(obsList.size()));
				resultLabel.setText(selected.getName().concat(" ").concat(selected.getSurname()));
			}
		}
	}

	@FXML
	void openTableManagement(ActionEvent event) {
		loadFXML(Modality.APPLICATION_MODAL, "fxml/management.fxml");
	}

	@FXML
	void openInfo(ActionEvent event) {
		loadFXML(Modality.APPLICATION_MODAL, "fxml/info.fxml");
	}
}