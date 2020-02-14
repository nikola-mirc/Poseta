package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Teacher;
import utils.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDAO {

	public static ObservableList<Teacher> getListFromTable(String table) {
		ObservableList<Teacher> list = FXCollections.observableArrayList();
		ResultSet rs = null;
		try {
			Connection connection = DBconnection.getConnection();
			String query = "SELECT * FROM " + table;
			rs = connection.createStatement().executeQuery(query);
			while (rs.next()) {
				list.add(new Teacher(rs.getString(2), rs.getString(3)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void insert(String table, String name, String surname) {
		String query = "INSERT INTO '" + table + "' (name, surname)" + "VALUES (?, ?)";
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(String table, String name, String surname) {
		String query = "DELETE FROM '" + table + "' WHERE name = ? AND surname = ?";
		try {
			Connection connection = DBconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ObservableList<String> getTableNames( ) {
		ObservableList<String> list = FXCollections.observableArrayList();
		ResultSet rs = null;
		try {
			Connection connection = DBconnection.getConnection();
			String query = "SELECT * FROM sqlite_master WHERE type='table'";
			rs = connection.createStatement().executeQuery(query);
			while (rs.next()) {
				list.add(rs.getString(2));
			}
			list.remove(0);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
