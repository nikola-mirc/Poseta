package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {

	private final StringProperty name;
	private final StringProperty surname;

	public Teacher(String name, String surname) {
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
	}

	public String getName() {
		return name.get();
	}

	public StringProperty getNameProperty() {
		return name;
	}

	public void setNameProperty(String name) {
		this.name.set(name);
	}

	public String getSurname() {
		return surname.get();
	}

	public StringProperty getSurnameProperty() {
		return surname;
	}

	public void setSurnameProperty(String surname) {
		this.surname.set(surname);
	}

	@Override
	public String toString() {
		return this.name + " " + this.surname;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!Teacher.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

		final Teacher other = (Teacher) obj;
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}

		if (this.surname != other.surname) {
			return false;
		}

		return true;
	}

}
