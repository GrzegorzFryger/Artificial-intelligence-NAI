package pl.edu.pja.nai.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import pl.edu.pja.nai.model.Movie;
import pl.edu.pja.nai.model.Reviewer;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EuclideanDistanceService {

	EuclideanDistance euclideanDistance;

	public EuclideanDistanceService(EuclideanDistance euclideanDistance) {
		this.euclideanDistance = euclideanDistance;
	}

	public double euclideanScore(Reviewer reviewer, Reviewer reviewer2) {

		List<Double> vector1 = reviewer.getListOfCommonMovies(reviewer)
				.stream()
				.map(Movie::getGrade)
				.collect(Collectors.toList());

		List<Double> vector2 = reviewer2.getListOfCommonMovies(reviewer2)
				.stream()
				.map(Movie::getGrade)
				.collect(Collectors.toList());

		if(vector1.size() < vector2.size()) {
			vector2 = vector2.subList(0,vector1.size());
		}

		if(vector2.size() < vector1.size()) {
			vector1 = vector1.subList(0,vector2.size());
		}

		return euclideanDistance.
				compute(ArrayUtils.toPrimitive(vector1.toArray(Double[]::new)),
						ArrayUtils.toPrimitive(vector2.toArray(Double[]::new))
				);

	}
}
