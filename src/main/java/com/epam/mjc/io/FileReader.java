package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {

        InputStream inputStream = null;
        try {
            inputStream = getFileFromResourceAsStream(String.valueOf(file));
        } catch (CustomRuntimeException e) {
        }

        Profile profile = null;
        try (InputStreamReader streamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
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
                    default:
                        break;
                }
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }

    private InputStream getFileFromResourceAsStream(String fileName) throws CustomRuntimeException {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new CustomRuntimeException(e);
        }
        return inputStream;
    }
}
