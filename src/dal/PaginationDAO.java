package dal;

import java.util.ArrayList;
import java.util.List;

import dto.Pages;

public class PaginationDAO {

	static List<Pages> paginate(String fileContent) {
		int wordsPerPage = 100;
		int pageNumber = 1;
		List<Pages> pages = new ArrayList<Pages>();

		if (fileContent == null || fileContent.trim().isEmpty()) {
			pages.add(new Pages(0, 0, pageNumber, "")); // Fixed: return empty page if content is null/empty
			return pages;
		}

		String[] allWords = fileContent.split("\\s+");
		StringBuilder currentPageContent = new StringBuilder();
		int currentWordCount = 0;

		for (int i = 0; i < allWords.length; i++) {
			if (currentWordCount > 0) {
				currentPageContent.append(" ");
			}
			currentPageContent.append(allWords[i]);
			currentWordCount++;

			if (currentWordCount == wordsPerPage || i == allWords.length - 1) {
				pages.add(new Pages(0, 0, pageNumber, currentPageContent.toString()));
				pageNumber++;
				currentPageContent = new StringBuilder();
				currentWordCount = 0;
			}
		}

		return pages;
	}
}
