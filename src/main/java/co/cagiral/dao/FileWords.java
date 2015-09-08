package co.cagiral.dao;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		this.filePath = filePath == null ? DEFAULT_FILE_PATH : filePath;
		System.out.println("~~Starting Dictionary from file on path: " + filePath);
		init();
	}

	public Set<String> getWords() {
		return words;
	}

	public void setWords(Set<String> words) {
		this.words = words;
	}

	private void init() {

		System.out.println("Reading file on path " + filePath);
		try {
			URL classloaderPath = ClassLoader.getSystemResource(filePath);

			Path path;
			if (classloaderPath != null) {

				path = Paths.get(classloaderPath.toURI());
			} else {

				path = Paths.get(filePath);
			}

			Charset charset = StandardCharsets.UTF_8;

			try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

				String line = null;
				while ((line = reader.readLine()) != null) {
					words.add(line);
				}
				reader.close();

			} catch (IOException ioe) {
				if (ioe instanceof MalformedInputException) {
					throw new RuntimeException("The file is not encoded in " + charset);
				}
				throw new RuntimeException("Can't Open file on " + path);
			}

		} catch (URISyntaxException e) {
			throw new RuntimeException("Can't find the file " + filePath);
		}

	}

	@Override
	public String getWord() {

		int index = new Random().nextInt(words.size());
		return (String) words.toArray()[index];
	}
}
