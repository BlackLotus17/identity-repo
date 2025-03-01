package com.identity.utilites;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TextExtractor {


    public String readFile() throws IOException {
        String data_dir = "car_input.txt";
        String filename = System.getProperty("user.dir") + "/src/main/resources/" + data_dir;
        Path pathToFile = Paths.get(filename);
        return new String(Files.readAllBytes(Paths.get(pathToFile.toAbsolutePath().toString())), StandardCharsets.UTF_8);
    }

    private static String readFileOut() throws IOException {
        String data_dir = "car_output.txt";
        String filename = System.getProperty("user.dir") + "/src/main/resources/" + data_dir;
        Path pathToFile = Paths.get(filename);
        return new String(Files.readAllBytes(Paths.get(pathToFile.toAbsolutePath().toString())), StandardCharsets.UTF_8);
    }

    public static List<String> extractValues() throws IOException {
        String [] allLines = readFileOut().split("\n");
        String[] remainingArrays = Arrays.copyOfRange(allLines, 1, allLines.length);
        return Arrays.asList(remainingArrays);
    }





}
