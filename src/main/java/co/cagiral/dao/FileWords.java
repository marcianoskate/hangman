package co.cagiral.dao;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class FileWords implements WordDictionary {

	private static final String DEFAULT_FILE_PATH = "dictionary/words.txt";
	private static String filePath;
	Set<String> words = new HashSet<>();

	public FileWords() {
		this(DEFAULT_FILE_PATH);
	}

	public FileWords(String filePath) {
		this.filePath = filePath;
		init();
	}

	public Set<String> getWords() {
		return words;
	}

	public void setWords(Set<String> words) {
		this.words = words;
	}

	private void init() {

		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();

		if (classLoader == null) {
			classLoader = Class.class.getClassLoader();
		}

		InputStream stream = classLoader.getResourceAsStream(filePath);
		if (stream == null) {

			File file = new File(classLoader.getResource(filePath).getFile());
			try {
				stream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("the file couldn't be located");
			}
		}

		Scanner scanner = new Scanner(stream);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			words.add(line);
		}

		scanner.close();


	}

	@Override
	public String getWord() {

		int index = new Random().nextInt(words.size());
		return (String) words.toArray()[index];
	}
}
