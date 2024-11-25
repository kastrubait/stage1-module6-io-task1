package com.epam.mjc.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReader {

    public Profile getDataFromFile(File file) {

        InputStream inputStream = getFileFromResourceAsStream(String.valueOf(file));

        Profile profile = null;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            String[] productData;
            line = reader.readLine();
            profile = new Profile();
            while (line != null) {
                String key = line.split(":")[0];
                String str;
                switch (key) {
                    case "Name":
                        str = line.split(":")[1];
                        profile.setName(str.trim());
                        break;
                    case "Age":
                        str = line.split(":")[1];
                        Integer age = Integer.valueOf(str.trim());
                        System.out.println(age);
                        profile.setAge(age);
                        break;
                    case "Email":
                        str = line.split(":")[1];
                        profile.setEmail(str.trim());
                        break;
                    case "Phone":
                        str = line.split(":")[1];
                        profile.setPhone(Long.valueOf(str.trim()));
                        break;
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }

    public static void main(String[] args) {

        File fileName = new File("Profile.txt");

        FileReader fileReader = new FileReader();
        Profile profile = fileReader.getDataFromFile(fileName);

    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

}
