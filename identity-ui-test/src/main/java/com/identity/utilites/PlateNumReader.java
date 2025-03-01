package com.identity.utilites;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PlateNumReader {

        private final static List<String> dataStore = new ArrayList<>();

        private final String carRegNumberRegex = "([A-Z]{2}[0-9]{2}[\\s*][A-Z]{3})|([A-Z]{2}[0-9]{2}[A-Z]{3})";
        private final Pattern pattern = Pattern.compile(carRegNumberRegex, Pattern.MULTILINE);


        public List<String> extractRegNumber()throws IOException {
            TextExtractor textExtractor = new TextExtractor();
            String data = textExtractor.readFile();
            final Matcher matcher = pattern.matcher(data);
            while (matcher.find()) {
                dataStore.add(matcher.group(0).replaceAll("\\s+", ""));
            }
            return dataStore;
        }
    }
