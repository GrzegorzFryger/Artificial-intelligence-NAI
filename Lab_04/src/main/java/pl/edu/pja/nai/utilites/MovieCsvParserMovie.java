package pl.edu.pja.nai.utilites;

import pl.edu.pja.nai.model.Movie;
import pl.edu.pja.nai.model.Reviewer;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieCsvParserMovie implements MovieFileParser {

	private Predicate<String> nullAndEmptyString = value -> value != null && value.length() > 0;

	private Function<String, Reviewer> mapToReviewer = (line) -> {
		String[] p = Arrays.stream(line.split(";"))
				.filter(this.nullAndEmptyString)
				.toArray(String[]::new);

		String[] splitStr = p[0].trim().split("\\s+");
		Reviewer reviewer =	new Reviewer(splitStr[0].trim(),splitStr[1].trim(), p[1].trim());
		for(int i = 2; i < p.length - 2 ; i += 2 ){
			reviewer.addMovie(
					new Movie (p[i], Double.valueOf(p[i + 1] ))
			);
		}
		return  reviewer;
	};

	public List<Reviewer> convertFile(String fileName)  {
		InputStream is = null;

		try {
			is = new FileInputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		return br.lines().map(mapToReviewer).collect(Collectors.toList());
	}






}