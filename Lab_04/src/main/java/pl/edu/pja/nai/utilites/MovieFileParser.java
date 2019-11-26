package pl.edu.pja.nai.utilites;

import pl.edu.pja.nai.model.Reviewer;

import java.util.List;

public interface MovieFileParser {
	List<Reviewer> convertFile(String fileName);
}
