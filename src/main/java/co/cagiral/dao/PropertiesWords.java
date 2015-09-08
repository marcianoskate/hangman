package co.cagiral.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class PropertiesWords {

	Set<String> words = new HashSet<>();

	public Set<String> getWords() {
		return words;
	}

	public void setWords(Set<String> words) {
		this.words = words;
	}

	public static void main(String[] args) {
		PropertiesWords prop = new PropertiesWords();
		prop.init("dictionary/words.txt");
		System.out.println(prop.getWords());
	}

	private void init(String fileName) {

		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				words.add(line);
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
