package pl.edu.pja.nai;

import pl.edu.pja.nai.service.MovieRecommendationService;

import java.io.IOException;

public class App {

	public static void main( String[] args ) throws IOException {

		MovieRecommendationService service = new MovieRecommendationService("movies.csv");
		service.setUserForRecommendation("Gregorz","Fryger");
		service.findMoviesRecommendation();

	}

}
