package pl.edu.pja.nai.model;

import java.util.function.Supplier;

public class Movie {

	private String name;
	private double grade;

	public Movie() { }

	public Movie(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return name  + "[ " + grade + " ]" ;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Movie)) return false;

		Movie movie = (Movie) o;

		return getName() != null ? getName().trim().equalsIgnoreCase(movie.getName().trim()) : movie.getName() == null;
	}

	@Override
	public int hashCode() {
		return getName() != null ? getName().hashCode() : 0;
	}
}

