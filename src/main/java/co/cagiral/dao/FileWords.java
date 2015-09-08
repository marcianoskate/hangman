package co.cagiral.dao;

import java.io.*;
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
    private static Path filePath;
    private static InputStream inputStream;

    Set<String> words = new HashSet<>();

    public FileWords() {
        this(null);
    }

    public FileWords(String providedPath) {


        String tempFilePath = providedPath == null ? DEFAULT_FILE_PATH : providedPath;
        if (providedPath == null) {
            inputStream = getStream(tempFilePath);
        } else {
            filePath = Paths.get(providedPath);
        }
        init();
    }

    public Set<String> getWords() {
        return words;
    }

    public void setWords(Set<String> words) {
        this.words = words;
    }

    private void init() {

        if (filePath != null) {

            readExternalFile();
        } else if (inputStream != null) {

            readFromResources();

        } else {
            throw new RuntimeException("Something went wrong creating the file");
        }
    }

    private void readFromResources() {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            words.add(line);
        }
    }

    private void readExternalFile() {
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            reader.close();

        } catch (IOException ioe) {
            if (ioe instanceof MalformedInputException) {
                throw new RuntimeException("The file is not encoded in " + StandardCharsets.UTF_8);
            }
            throw new RuntimeException("Can't Open file on " + filePath);
        }
    }

    private InputStream getStream(String filepath) {

        ClassLoader classLoader = getClass().getClassLoader();

        if (classLoader == null) {
            classLoader = Class.class.getClassLoader();
        }

        InputStream stream = classLoader.getResourceAsStream(filepath);
        if (stream == null) {

            File file = new File(classLoader.getResource(filepath).getFile());
            try {
                stream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("the file couldn't be located");
            }
        }
        return stream;
    }

    @Override
    public String getWord() {

        int index = new Random().nextInt(words.size());
        return (String) words.toArray()[index];
    }
}
