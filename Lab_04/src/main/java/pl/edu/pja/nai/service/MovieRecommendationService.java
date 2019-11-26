package pl.edu.pja.nai.service;

import org.apache.commons.math3.ml.distance.EuclideanDistance;
import pl.edu.pja.nai.model.Movie;
import pl.edu.pja.nai.model.Reviewer;
import pl.edu.pja.nai.utilites.MovieCsvParserMovie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRecommendationService {

		private List<Reviewer> reviewers;
		private Reviewer currentReviewer;
		private EuclideanDistanceService euclideanDistanceService;

		public MovieRecommendationService(String fileName) {
			reviewers = new MovieCsvParserMovie().convertFile(fileName);
			euclideanDistanceService = new EuclideanDistanceService(new EuclideanDistance());
		}

		public void setUserForRecommendation(String name, String surname) {

			reviewers.forEach(reviewer -> {
				if(reviewer.getSurname().equalsIgnoreCase(surname)) {
					currentReviewer = reviewer;
				}
			});

			System.out.println(currentReviewer.getFullname());

			reviewers.remove(currentReviewer);
		}

		public void findMoviesRecommendation() {
			reviewers.forEach(reviewer ->
				reviewer.setEuclideanDistance(euclideanDistanceService.euclideanScore(currentReviewer, reviewer))
			);

			reviewers.sort(Comparator
					.comparingDouble(Reviewer::euclideanDistance)
					.reversed()
			);

			this.displayRecommendedMovies(this.getListOfRecommendedMovies());
			this.displayNotRecommendedMovies(this.getListOfNotRecommendedMovies());
		}

		private List<Movie> getListOfNotRecommendedMovies() {

			List<Movie> movies = new ArrayList<>();


			for (int i = 0; i < 10; i++) {
				movies.addAll(
						reviewers.get(i).getMovies()
								.stream()
								.filter(x -> !containsMovieInList(x,currentReviewer.getMovies()))
								.sorted(Comparator.comparingDouble(Movie::getGrade))
								.limit(5)
								.collect(Collectors.toList())
				);
			}
			return movies.stream().distinct().limit(10).collect(Collectors.toList());
		}

		private List<Movie> getListOfRecommendedMovies() {

			List<Movie> movies = new ArrayList<>();

			for (int i = 0; i <10; i++) {
				movies.addAll(

						reviewers.get(i).getMovies()
								.stream()
								.filter(x -> !containsMovieInList(x, currentReviewer.getMovies()))
								.sorted(Comparator.comparingDouble(Movie::getGrade).reversed())
								.limit(5)
								.collect(Collectors.toList())
				);
			}

			return movies.stream().distinct().limit(10).collect(Collectors.toList());
		}

		private void displayRecommendedMovies(List<Movie> recommendedMovies) {
			System.out.println("List of recommended movies: ");
			recommendedMovies.forEach(System.out::println);
			System.out.println();
		}
		private void displayNotRecommendedMovies(List<Movie> notRecommendedMovies) {
			System.out.println("List of not recommended movies: ");
			notRecommendedMovies.forEach(System.out::println);
			System.out.println();
		}

		private boolean containsMovieInList(Movie movie, List<Movie> movies) {
			return  movies.stream()
					.anyMatch(l -> l.getName().trim()
					.equalsIgnoreCase(movie.getName().trim()));
		}
}

