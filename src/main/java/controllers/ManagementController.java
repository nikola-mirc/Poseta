package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import dao.TeacherDAO;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Teacher;

public class ManagementController implements Initializable {

	@FXML
	private TableView<Teacher> tablePon1, tablePon2, tablePon3, tablePon4, tablePon5, tablePon6, tablePon7, tablePon8,
			tableUto1, tableUto2, tableUto3, tableUto4, tableUto5, tableUto6, tableUto7, tableUto8, tableSre1,
			tableSre2, tableSre3, tableSre4, tableSre5, tableSre6, tableSre7, tableSre8, tableCet1, tableCet2,
			tableCet3, tableCet4, tableCet5, tableCet6, tableCet7, tableCet8, tablePet1, tablePet2, tablePet3,
			tablePet4, tablePet5, tablePet6, tablePet7, tablePet8;

	@FXML
	private TableColumn<Teacher, String> colPon1, colPon2, colPon3, colPon4, colPon5, colPon6, colPon7, colPon8,
			colUto1, colUto2, colUto3, colUto4, colUto5, colUto6, colUto7, colUto8, colSre1, colSre2, colSre3, colSre4,
			colSre5, colSre6, colSre7, colSre8, colCet1, colCet2, colCet3, colCet4, colCet5, colCet6, colCet7, colCet8,
			colPet1, colPet2, colPet3, colPet4, colPet5, colPet6, colPet7, colPet8;

	@FXML
	private JFXButton addTablePon1, addTablePon2, addTablePon3, addTablePon4, addTablePon5, addTablePon6, addTablePon7,
			addTablePon8, addTableUto1, addTableUto2, addTableUto3, addTableUto4, addTableUto5, addTableUto6,
			addTableUto7, addTableUto8, addTableSre1, addTableSre2, addTableSre3, addTableSre4, addTableSre5,
			addTableSre6, addTableSre7, addTableSre8, addTableCet1, addTableCet2, addTableCet3, addTableCet4,
			addTableCet5, addTableCet6, addTableCet7, addTableCet8, addTablePet1, addTablePet2, addTablePet3,
			addTablePet4, addTablePet5, addTablePet6, addTablePet7, addTablePet8;

	@FXML
	private JFXButton removeTablePon1, removeTablePon2, removeTablePon3, removeTablePon4, removeTablePon5,
			removeTablePon6, removeTablePon7, removeTablePon8, removeTableUto1, removeTableUto2, removeTableUto3,
			removeTableUto4, removeTableUto5, removeTableUto6, removeTableUto7, removeTableUto8, removeTableSre1,
			removeTableSre2, removeTableSre3, removeTableSre4, removeTableSre5, removeTableSre6, removeTableSre7,
			removeTableSre8, removeTableCet1, removeTableCet2, removeTableCet3, removeTableCet4, removeTableCet5,
			removeTableCet6, removeTableCet7, removeTableCet8, removeTablePet1, removeTablePet2, removeTablePet3,
			removeTablePet4, removeTablePet5, removeTablePet6, removeTablePet7, removeTablePet8;

	@FXML
	private JFXButton addBtn, removeBtn;

	@FXML
	private TextField searchTextfield, nameTextField, surnameTextField;

	@FXML
	private TableView<Teacher> tableAll;

	@FXML
	private TableColumn<Teacher, String> colAll;

	private ObservableList<Teacher> obsList;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		initializeTables();
		disableButtonsUntilSelection();
		initializeSearch();
	}

	@FXML
	void addToAll(ActionEvent event) {
		TeacherDAO.insert("nastavnici", nameTextField.getText(), surnameTextField.getText());
		nameTextField.clear();
		surnameTextField.clear();
		loadTable(tableAll, colAll, "nastavnici");
		initializeSearch();
	}

	@FXML
	void removeFromAll(ActionEvent event) throws InterruptedException {
		String name = tableAll.getSelectionModel().getSelectedItem().getName();
		String surname = tableAll.getSelectionModel().getSelectedItem().getSurname();
		ObservableList<String> allTablesList = TeacherDAO.getTableNames();

		ButtonType answer = confirmationAlert(AlertType.CONFIRMATION, "Poseta", (name + " " + surname
				+ " će biti izbrisan iz tabele 'nastavnici' i iz svih tabela u bazi. Da li ste sigurni?"));

		if (answer == ButtonType.OK) {
			for (String string : allTablesList) {
				TeacherDAO.delete(string, name, surname);
			}
			Thread.sleep(500);
			initializeTables();
		}
	}

	/**
	 * MONDAY INSERT/DELETE
	 */

	@FXML
	void addTablePon1(ActionEvent event) {
		TeacherDAO.insert("ponedeljak1", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon1, colPon1, "ponedeljak1");
	}

	@FXML
	void addTablePon2(ActionEvent event) {
		TeacherDAO.insert("ponedeljak2", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon2, colPon2, "ponedeljak2");
	}

	@FXML
	void addTablePon3(ActionEvent event) {
		TeacherDAO.insert("ponedeljak3", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon3, colPon3, "ponedeljak3");
	}

	@FXML
	void addTablePon4(ActionEvent event) {
		TeacherDAO.insert("ponedeljak4", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon4, colPon4, "ponedeljak4");
	}

	@FXML
	void addTablePon5(ActionEvent event) {
		TeacherDAO.insert("ponedeljak5", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon5, colPon5, "ponedeljak5");
	}

	@FXML
	void addTablePon6(ActionEvent event) {
		TeacherDAO.insert("ponedeljak6", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon6, colPon6, "ponedeljak6");
	}

	@FXML
	void addTablePon7(ActionEvent event) {
		TeacherDAO.insert("ponedeljak7", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon7, colPon7, "ponedeljak7");
	}

	@FXML
	void addTablePon8(ActionEvent event) {
		TeacherDAO.insert("ponedeljak8", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon8, colPon8, "ponedeljak8");
	}

	@FXML
	void removeTablePon1(ActionEvent event) {
		TeacherDAO.delete("ponedeljak1", tablePon1.getSelectionModel().getSelectedItem().getName(),
				tablePon1.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon1, colPon1, "ponedeljak1");
	}

	@FXML
	void removeTablePon2(ActionEvent event) {
		TeacherDAO.delete("ponedeljak2", tablePon2.getSelectionModel().getSelectedItem().getName(),
				tablePon2.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon2, colPon2, "ponedeljak2");
	}

	@FXML
	void removeTablePon3(ActionEvent event) {
		TeacherDAO.delete("ponedeljak3", tablePon3.getSelectionModel().getSelectedItem().getName(),
				tablePon3.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon3, colPon3, "ponedeljak3");
	}

	@FXML
	void removeTablePon4(ActionEvent event) {
		TeacherDAO.delete("ponedeljak4", tablePon4.getSelectionModel().getSelectedItem().getName(),
				tablePon4.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon4, colPon4, "ponedeljak4");
	}

	@FXML
	void removeTablePon5(ActionEvent event) {
		TeacherDAO.delete("ponedeljak5", tablePon5.getSelectionModel().getSelectedItem().getName(),
				tablePon5.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon5, colPon5, "ponedeljak5");
	}

	@FXML
	void removeTablePon6(ActionEvent event) {
		TeacherDAO.delete("ponedeljak6", tablePon6.getSelectionModel().getSelectedItem().getName(),
				tablePon6.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon6, colPon6, "ponedeljak6");
	}

	@FXML
	void removeTablePon7(ActionEvent event) {
		TeacherDAO.delete("ponedeljak7", tablePon7.getSelectionModel().getSelectedItem().getName(),
				tablePon7.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon7, colPon7, "ponedeljak7");
	}

	@FXML
	void removeTablePon8(ActionEvent event) {
		TeacherDAO.delete("ponedeljak8", tablePon8.getSelectionModel().getSelectedItem().getName(),
				tablePon8.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePon8, colPon8, "ponedeljak8");
	}

	/**
	 * TUESDAY INSERT/DELETE
	 */

	@FXML
	void addTableUto1(ActionEvent event) {
		TeacherDAO.insert("utorak1", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto1, colUto1, "utorak1");
	}

	@FXML
	void addTableUto2(ActionEvent event) {
		TeacherDAO.insert("utorak2", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto2, colUto2, "utorak2");
	}

	@FXML
	void addTableUto3(ActionEvent event) {
		TeacherDAO.insert("utorak3", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto3, colUto3, "utorak3");
	}

	@FXML
	void addTableUto4(ActionEvent event) {
		TeacherDAO.insert("utorak4", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto4, colUto4, "utorak4");
	}

	@FXML
	void addTableUto5(ActionEvent event) {
		TeacherDAO.insert("utorak5", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto5, colUto5, "utorak5");
	}

	@FXML
	void addTableUto6(ActionEvent event) {
		TeacherDAO.insert("utorak6", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto6, colUto6, "utorak6");
	}

	@FXML
	void addTableUto7(ActionEvent event) {
		TeacherDAO.insert("utorak7", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto7, colUto7, "utorak7");
	}

	@FXML
	void addTableUto8(ActionEvent event) {
		TeacherDAO.insert("utorak8", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto8, colUto8, "utorak8");
	}

	@FXML
	void removeTableUto1(ActionEvent event) {
		TeacherDAO.delete("utorak1", tableUto1.getSelectionModel().getSelectedItem().getName(),
				tableUto1.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto1, colUto1, "utorak1");
	}

	@FXML
	void removeTableUto2(ActionEvent event) {
		TeacherDAO.delete("utorak2", tableUto2.getSelectionModel().getSelectedItem().getName(),
				tableUto2.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto2, colUto2, "utorak2");
	}

	@FXML
	void removeTableUto3(ActionEvent event) {
		TeacherDAO.delete("utorak3", tableUto3.getSelectionModel().getSelectedItem().getName(),
				tableUto3.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto3, colUto3, "utorak3");
	}

	@FXML
	void removeTableUto4(ActionEvent event) {
		TeacherDAO.delete("utorak4", tableUto4.getSelectionModel().getSelectedItem().getName(),
				tableUto4.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto4, colUto4, "utorak4");
	}

	@FXML
	void removeTableUto5(ActionEvent event) {
		TeacherDAO.delete("utorak5", tableUto5.getSelectionModel().getSelectedItem().getName(),
				tableUto5.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto5, colUto5, "utorak5");
	}

	@FXML
	void removeTableUto6(ActionEvent event) {
		TeacherDAO.delete("utorak6", tableUto6.getSelectionModel().getSelectedItem().getName(),
				tableUto6.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto6, colUto6, "utorak6");
	}

	@FXML
	void removeTableUto7(ActionEvent event) {
		TeacherDAO.delete("utorak7", tableUto7.getSelectionModel().getSelectedItem().getName(),
				tableUto7.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto7, colUto7, "utorak7");
	}

	@FXML
	void removeTableUto8(ActionEvent event) {
		TeacherDAO.delete("utorak8", tableUto8.getSelectionModel().getSelectedItem().getName(),
				tableUto8.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableUto8, colUto8, "utorak8");
	}

	/**
	 * WEDNESDAY INSERT/DELETE
	 */

	@FXML
	void addTableSre1(ActionEvent event) {
		TeacherDAO.insert("sreda1", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre1, colSre1, "sreda1");
	}

	@FXML
	void addTableSre2(ActionEvent event) {
		TeacherDAO.insert("sreda2", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre2, colSre2, "sreda2");
	}

	@FXML
	void addTableSre3(ActionEvent event) {
		TeacherDAO.insert("sreda3", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre3, colSre3, "sreda3");
	}

	@FXML
	void addTableSre4(ActionEvent event) {
		TeacherDAO.insert("sreda4", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre4, colSre4, "sreda4");
	}

	@FXML
	void addTableSre5(ActionEvent event) {
		TeacherDAO.insert("sreda5", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre5, colSre5, "sreda5");
	}

	@FXML
	void addTableSre6(ActionEvent event) {
		TeacherDAO.insert("sreda6", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre6, colSre6, "sreda6");
	}

	@FXML
	void addTableSre7(ActionEvent event) {
		TeacherDAO.insert("sreda7", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre7, colSre7, "sreda7");
	}

	@FXML
	void addTableSre8(ActionEvent event) {
		TeacherDAO.insert("sreda8", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre8, colSre8, "sreda8");
	}

	@FXML
	void removeTableSre1(ActionEvent event) {
		TeacherDAO.delete("sreda1", tableSre1.getSelectionModel().getSelectedItem().getName(),
				tableSre1.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre1, colSre1, "sreda1");
	}

	@FXML
	void removeTableSre2(ActionEvent event) {
		TeacherDAO.delete("sreda2", tableSre2.getSelectionModel().getSelectedItem().getName(),
				tableSre2.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre2, colSre2, "sreda2");
	}

	@FXML
	void removeTableSre3(ActionEvent event) {
		TeacherDAO.delete("sreda3", tableSre3.getSelectionModel().getSelectedItem().getName(),
				tableSre3.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre3, colSre3, "sreda3");
	}

	@FXML
	void removeTableSre4(ActionEvent event) {
		TeacherDAO.delete("sreda4", tableSre4.getSelectionModel().getSelectedItem().getName(),
				tableSre4.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre4, colSre4, "sreda4");
	}

	@FXML
	void removeTableSre5(ActionEvent event) {
		TeacherDAO.delete("sreda5", tableSre5.getSelectionModel().getSelectedItem().getName(),
				tableSre5.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre5, colSre5, "sreda5");
	}

	@FXML
	void removeTableSre6(ActionEvent event) {
		TeacherDAO.delete("sreda6", tableSre6.getSelectionModel().getSelectedItem().getName(),
				tableSre6.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre6, colSre6, "sreda6");
	}

	@FXML
	void removeTableSre7(ActionEvent event) {
		TeacherDAO.delete("sreda7", tableSre7.getSelectionModel().getSelectedItem().getName(),
				tableSre7.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre7, colSre7, "sreda7");
	}

	@FXML
	void removeTableSre8(ActionEvent event) {
		TeacherDAO.delete("sreda8", tableSre8.getSelectionModel().getSelectedItem().getName(),
				tableSre8.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableSre8, colSre8, "sreda8");
	}

	/**
	 * THURSDAY INSERT/DELETE
	 */

	@FXML
	void addTableCet1(ActionEvent event) {
		TeacherDAO.insert("cetvrtak1", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet1, colCet1, "cetvrtak1");
	}

	@FXML
	void addTableCet2(ActionEvent event) {
		TeacherDAO.insert("cetvrtak2", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet2, colCet2, "cetvrtak2");
	}

	@FXML
	void addTableCet3(ActionEvent event) {
		TeacherDAO.insert("cetvrtak3", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet3, colCet3, "cetvrtak3");
	}

	@FXML
	void addTableCet4(ActionEvent event) {
		TeacherDAO.insert("cetvrtak4", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet4, colCet4, "cetvrtak4");
	}

	@FXML
	void addTableCet5(ActionEvent event) {
		TeacherDAO.insert("cetvrtak5", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet5, colCet5, "cetvrtak5");
	}

	@FXML
	void addTableCet6(ActionEvent event) {
		TeacherDAO.insert("cetvrtak6", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet6, colCet6, "cetvrtak6");
	}

	@FXML
	void addTableCet7(ActionEvent event) {
		TeacherDAO.insert("cetvrtak7", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet7, colCet7, "cetvrtak7");
	}

	@FXML
	void addTableCet8(ActionEvent event) {
		TeacherDAO.insert("cetvrtak8", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet8, colCet8, "cetvrtak8");
	}

	@FXML
	void removeTableCet1(ActionEvent event) {
		TeacherDAO.delete("cetvrtak1", tableCet1.getSelectionModel().getSelectedItem().getName(),
				tableCet1.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet1, colCet1, "cetvrtak1");
	}

	@FXML
	void removeTableCet2(ActionEvent event) {
		TeacherDAO.delete("cetvrtak2", tableCet2.getSelectionModel().getSelectedItem().getName(),
				tableCet2.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet2, colCet2, "cetvrtak2");
	}

	@FXML
	void removeTableCet3(ActionEvent event) {
		TeacherDAO.delete("cetvrtak3", tableCet3.getSelectionModel().getSelectedItem().getName(),
				tableCet3.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet3, colCet3, "cetvrtak3");
	}

	@FXML
	void removeTableCet4(ActionEvent event) {
		TeacherDAO.delete("cetvrtak4", tableCet4.getSelectionModel().getSelectedItem().getName(),
				tableCet4.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet4, colCet4, "cetvrtak4");
	}

	@FXML
	void removeTableCet5(ActionEvent event) {
		TeacherDAO.delete("cetvrtak5", tableCet5.getSelectionModel().getSelectedItem().getName(),
				tableCet5.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet5, colCet5, "cetvrtak5");
	}

	@FXML
	void removeTableCet6(ActionEvent event) {
		TeacherDAO.delete("cetvrtak6", tableCet6.getSelectionModel().getSelectedItem().getName(),
				tableCet6.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet6, colCet6, "cetvrtak6");
	}

	@FXML
	void removeTableCet7(ActionEvent event) {
		TeacherDAO.delete("cetvrtak7", tableCet7.getSelectionModel().getSelectedItem().getName(),
				tableCet7.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet7, colCet7, "cetvrtak7");
	}

	@FXML
	void removeTableCet8(ActionEvent event) {
		TeacherDAO.delete("cetvrtak8", tableCet8.getSelectionModel().getSelectedItem().getName(),
				tableCet8.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tableCet8, colCet8, "cetvrtak8");
	}

	/**
	 * FRIDAY INSERT/DELETE
	 */

	@FXML
	void addTablePet1(ActionEvent event) {
		TeacherDAO.insert("petak1", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet1, colPet1, "petak1");
	}

	@FXML
	void addTablePet2(ActionEvent event) {
		TeacherDAO.insert("petak2", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet2, colPet2, "petak2");
	}

	@FXML
	void addTablePet3(ActionEvent event) {
		TeacherDAO.insert("petak3", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet3, colPet3, "petak3");
	}

	@FXML
	void addTablePet4(ActionEvent event) {
		TeacherDAO.insert("petak4", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet4, colPet4, "petak4");
	}

	@FXML
	void addTablePet5(ActionEvent event) {
		TeacherDAO.insert("petak5", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet5, colPet5, "petak5");
	}

	@FXML
	void addTablePet6(ActionEvent event) {
		TeacherDAO.insert("petak6", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet6, colPet6, "petak6");
	}

	@FXML
	void addTablePet7(ActionEvent event) {
		TeacherDAO.insert("petak7", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet7, colPet7, "petak7");
	}

	@FXML
	void addTablePet8(ActionEvent event) {
		TeacherDAO.insert("petak8", tableAll.getSelectionModel().getSelectedItem().getName(),
				tableAll.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet8, colPet8, "petak8");
	}

	@FXML
	void removeTablePet1(ActionEvent event) {
		TeacherDAO.delete("petak1", tablePet1.getSelectionModel().getSelectedItem().getName(),
				tablePet1.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet1, colPet1, "petak1");
	}

	@FXML
	void removeTablePet2(ActionEvent event) {
		TeacherDAO.delete("petak2", tablePet2.getSelectionModel().getSelectedItem().getName(),
				tablePet2.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet2, colPet2, "petak2");
	}

	@FXML
	void removeTablePet3(ActionEvent event) {
		TeacherDAO.delete("petak3", tablePet3.getSelectionModel().getSelectedItem().getName(),
				tablePet3.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet3, colPet3, "petak3");
	}

	@FXML
	void removeTablePet4(ActionEvent event) {
		TeacherDAO.delete("petak4", tablePet4.getSelectionModel().getSelectedItem().getName(),
				tablePet4.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet4, colPet4, "petak4");
	}

	@FXML
	void removeTablePet5(ActionEvent event) {
		TeacherDAO.delete("petak5", tablePet5.getSelectionModel().getSelectedItem().getName(),
				tablePet5.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet5, colPet5, "petak5");
	}

	@FXML
	void removeTablePet6(ActionEvent event) {
		TeacherDAO.delete("petak6", tablePet6.getSelectionModel().getSelectedItem().getName(),
				tablePet6.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet6, colPet6, "petak6");
	}

	@FXML
	void removeTablePet7(ActionEvent event) {
		TeacherDAO.delete("petak7", tablePet7.getSelectionModel().getSelectedItem().getName(),
				tablePet7.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet7, colPet7, "petak7");
	}

	@FXML
	void removeTablePet8(ActionEvent event) {
		TeacherDAO.delete("petak8", tablePet8.getSelectionModel().getSelectedItem().getName(),
				tablePet8.getSelectionModel().getSelectedItem().getSurname());
		loadTable(tablePet8, colPet8, "petak8");
	}

	/**
	 * util methods
	 */

	private void loadTable(TableView<Teacher> tableView, TableColumn<Teacher, String> tableColumn, String dbTableName) {
		obsList = TeacherDAO.getListFromTable(dbTableName);
		tableColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty().concat(" ")
				.concat(cellData.getValue().getSurnameProperty()));
		tableView.setItems(obsList);
	}

	private void initializeTables() {
		// main table
		loadTable(tableAll, colAll, "nastavnici");
		// monday
		loadTable(tablePon1, colPon1, "ponedeljak1");
		loadTable(tablePon2, colPon2, "ponedeljak2");
		loadTable(tablePon3, colPon3, "ponedeljak3");
		loadTable(tablePon4, colPon4, "ponedeljak4");
		loadTable(tablePon5, colPon5, "ponedeljak5");
		loadTable(tablePon6, colPon6, "ponedeljak6");
		loadTable(tablePon7, colPon7, "ponedeljak7");
		loadTable(tablePon8, colPon8, "ponedeljak8");
		// tuesday
		loadTable(tableUto1, colUto1, "utorak1");
		loadTable(tableUto2, colUto2, "utorak2");
		loadTable(tableUto3, colUto3, "utorak3");
		loadTable(tableUto4, colUto4, "utorak4");
		loadTable(tableUto5, colUto5, "utorak5");
		loadTable(tableUto6, colUto6, "utorak6");
		loadTable(tableUto7, colUto7, "utorak7");
		loadTable(tableUto8, colUto8, "utorak8");
		// wednesday
		loadTable(tableSre1, colSre1, "sreda1");
		loadTable(tableSre2, colSre2, "sreda2");
		loadTable(tableSre3, colSre3, "sreda3");
		loadTable(tableSre4, colSre4, "sreda4");
		loadTable(tableSre5, colSre5, "sreda5");
		loadTable(tableSre6, colSre6, "sreda6");
		loadTable(tableSre7, colSre7, "sreda7");
		loadTable(tableSre8, colSre8, "sreda8");
		// thursday
		loadTable(tableCet1, colCet1, "cetvrtak1");
		loadTable(tableCet2, colCet2, "cetvrtak2");
		loadTable(tableCet3, colCet3, "cetvrtak3");
		loadTable(tableCet4, colCet4, "cetvrtak4");
		loadTable(tableCet5, colCet5, "cetvrtak5");
		loadTable(tableCet6, colCet6, "cetvrtak6");
		loadTable(tableCet7, colCet7, "cetvrtak7");
		loadTable(tableCet8, colCet8, "cetvrtak8");
		// friday
		loadTable(tablePet1, colPet1, "petak1");
		loadTable(tablePet2, colPet2, "petak2");
		loadTable(tablePet3, colPet3, "petak3");
		loadTable(tablePet4, colPet4, "petak4");
		loadTable(tablePet5, colPet5, "petak5");
		loadTable(tablePet6, colPet6, "petak6");
		loadTable(tablePet7, colPet7, "petak7");
		loadTable(tablePet8, colPet8, "petak8");
	}

	private void initializeSearch() {
		ObservableList<Teacher> searchList = TeacherDAO.getListFromTable("nastavnici");
		FilteredList<Teacher> filteredData = new FilteredList<>(searchList, predicate -> true);
		searchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(teacher -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (teacher.getName().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else if (teacher.getSurname().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});
		SortedList<Teacher> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableAll.comparatorProperty());
		tableAll.setItems(sortedData);
	}

	private void disableButtonsUntilSelection() {
		BooleanBinding booleanBinding = new BooleanBinding() {
			{
				super.bind(nameTextField.textProperty(), surnameTextField.textProperty());
			}

			@Override
			protected boolean computeValue() {
				return (nameTextField.getText().isEmpty() || surnameTextField.getText().isEmpty());
			}
		};

		addBtn.disableProperty().bind(booleanBinding);
		removeBtn.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));

		addTablePon1.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePon2.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePon3.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePon4.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePon5.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePon6.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePon7.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePon8.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));

		addTableUto1.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableUto2.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableUto3.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableUto4.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableUto5.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableUto6.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableUto7.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableUto8.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));

		addTableSre1.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableSre2.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableSre3.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableSre4.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableSre5.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableSre6.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableSre7.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableSre8.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));

		addTableCet1.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableCet2.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableCet3.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableCet4.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableCet5.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableCet6.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableCet7.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTableCet8.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));

		addTablePet1.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePet2.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePet3.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePet4.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePet5.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePet6.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePet7.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));
		addTablePet8.disableProperty().bind(Bindings.isEmpty(tableAll.getSelectionModel().getSelectedItems()));

		removeTablePon1.disableProperty().bind(Bindings.isEmpty(tablePon1.getSelectionModel().getSelectedItems()));
		removeTablePon2.disableProperty().bind(Bindings.isEmpty(tablePon2.getSelectionModel().getSelectedItems()));
		removeTablePon3.disableProperty().bind(Bindings.isEmpty(tablePon3.getSelectionModel().getSelectedItems()));
		removeTablePon4.disableProperty().bind(Bindings.isEmpty(tablePon4.getSelectionModel().getSelectedItems()));
		removeTablePon5.disableProperty().bind(Bindings.isEmpty(tablePon5.getSelectionModel().getSelectedItems()));
		removeTablePon6.disableProperty().bind(Bindings.isEmpty(tablePon6.getSelectionModel().getSelectedItems()));
		removeTablePon7.disableProperty().bind(Bindings.isEmpty(tablePon7.getSelectionModel().getSelectedItems()));
		removeTablePon8.disableProperty().bind(Bindings.isEmpty(tablePon8.getSelectionModel().getSelectedItems()));

		removeTableUto1.disableProperty().bind(Bindings.isEmpty(tableUto1.getSelectionModel().getSelectedItems()));
		removeTableUto2.disableProperty().bind(Bindings.isEmpty(tableUto2.getSelectionModel().getSelectedItems()));
		removeTableUto3.disableProperty().bind(Bindings.isEmpty(tableUto3.getSelectionModel().getSelectedItems()));
		removeTableUto4.disableProperty().bind(Bindings.isEmpty(tableUto4.getSelectionModel().getSelectedItems()));
		removeTableUto5.disableProperty().bind(Bindings.isEmpty(tableUto5.getSelectionModel().getSelectedItems()));
		removeTableUto6.disableProperty().bind(Bindings.isEmpty(tableUto6.getSelectionModel().getSelectedItems()));
		removeTableUto7.disableProperty().bind(Bindings.isEmpty(tableUto7.getSelectionModel().getSelectedItems()));
		removeTableUto8.disableProperty().bind(Bindings.isEmpty(tableUto8.getSelectionModel().getSelectedItems()));

		removeTableSre1.disableProperty().bind(Bindings.isEmpty(tableSre1.getSelectionModel().getSelectedItems()));
		removeTableSre2.disableProperty().bind(Bindings.isEmpty(tableSre2.getSelectionModel().getSelectedItems()));
		removeTableSre3.disableProperty().bind(Bindings.isEmpty(tableSre3.getSelectionModel().getSelectedItems()));
		removeTableSre4.disableProperty().bind(Bindings.isEmpty(tableSre4.getSelectionModel().getSelectedItems()));
		removeTableSre5.disableProperty().bind(Bindings.isEmpty(tableSre5.getSelectionModel().getSelectedItems()));
		removeTableSre6.disableProperty().bind(Bindings.isEmpty(tableSre6.getSelectionModel().getSelectedItems()));
		removeTableSre7.disableProperty().bind(Bindings.isEmpty(tableSre7.getSelectionModel().getSelectedItems()));
		removeTableSre8.disableProperty().bind(Bindings.isEmpty(tableSre8.getSelectionModel().getSelectedItems()));

		removeTableCet1.disableProperty().bind(Bindings.isEmpty(tableCet1.getSelectionModel().getSelectedItems()));
		removeTableCet2.disableProperty().bind(Bindings.isEmpty(tableCet2.getSelectionModel().getSelectedItems()));
		removeTableCet3.disableProperty().bind(Bindings.isEmpty(tableCet3.getSelectionModel().getSelectedItems()));
		removeTableCet4.disableProperty().bind(Bindings.isEmpty(tableCet4.getSelectionModel().getSelectedItems()));
		removeTableCet5.disableProperty().bind(Bindings.isEmpty(tableCet5.getSelectionModel().getSelectedItems()));
		removeTableCet6.disableProperty().bind(Bindings.isEmpty(tableCet6.getSelectionModel().getSelectedItems()));
		removeTableCet7.disableProperty().bind(Bindings.isEmpty(tableCet7.getSelectionModel().getSelectedItems()));
		removeTableCet8.disableProperty().bind(Bindings.isEmpty(tableCet8.getSelectionModel().getSelectedItems()));

		removeTablePet1.disableProperty().bind(Bindings.isEmpty(tablePet1.getSelectionModel().getSelectedItems()));
		removeTablePet2.disableProperty().bind(Bindings.isEmpty(tablePet2.getSelectionModel().getSelectedItems()));
		removeTablePet3.disableProperty().bind(Bindings.isEmpty(tablePet3.getSelectionModel().getSelectedItems()));
		removeTablePet4.disableProperty().bind(Bindings.isEmpty(tablePet4.getSelectionModel().getSelectedItems()));
		removeTablePet5.disableProperty().bind(Bindings.isEmpty(tablePet5.getSelectionModel().getSelectedItems()));
		removeTablePet6.disableProperty().bind(Bindings.isEmpty(tablePet6.getSelectionModel().getSelectedItems()));
		removeTablePet7.disableProperty().bind(Bindings.isEmpty(tablePet7.getSelectionModel().getSelectedItems()));
		removeTablePet8.disableProperty().bind(Bindings.isEmpty(tablePet8.getSelectionModel().getSelectedItems()));
	}

	private ButtonType confirmationAlert(AlertType alertType, String title, String contentText) {
		Alert alert = new Alert(alertType);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

		((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Da");
		((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("Otkaži");

		stage.getIcons().add(new Image("/images/icon.png"));

		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setGraphic(null);
		alert.setContentText(contentText);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.showAndWait();

		return alert.getResult();
	}

}