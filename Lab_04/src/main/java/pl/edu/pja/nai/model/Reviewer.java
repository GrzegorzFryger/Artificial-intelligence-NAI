package pl.edu.pja.nai.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reviewer {

	private String  name;
	private String surname;
	private String group;
	private List<Movie> movies = new ArrayList<>();
	private Double euclideanDistance;

	public Reviewer( String name, String surname, String group) {
		this.name = name;
		this.surname = surname;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Double getEuclideanDistance() {
		return euclideanDistance;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public String getFullname(){
		return name + " " + surname;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public void addMovie(Movie movie){
		this.movies.add(movie);
	}

	public Double euclideanDistance() {
		return this.euclideanDistance;
	}

	public void setEuclideanDistance(Double euclideanScore) {
		this.euclideanDistance = euclideanScore;
	}

	public List<Movie> getListOfCommonMovies(Reviewer reviewer) {
		return movies.stream()
				.filter(reviewer.movies::contains)
				.collect(Collectors.toList());
	}
}
