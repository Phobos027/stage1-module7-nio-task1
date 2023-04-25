package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileReader {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
    }

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try {
            List<String> strings = Files.readAllLines(Paths.get(String.valueOf(file)));

            String[] name = strings.get(0).split(" ");
            String[] age = strings.get(1).split(" ");
            String[] eMail = strings.get(2).split(" ");
            String[] phone = strings.get(3).split(" ");

            profile.setName(name[1]);
            profile.setAge(Integer.parseInt(age[1]));
            profile.setEmail(eMail[1]);
            profile.setPhone(Long.parseLong(phone[1]));
            //file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone());
    }
}
