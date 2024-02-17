package org.example;

import org.example.models.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir")+"/src/main/resources/task.csv"));
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] fields = str.split(";");
            try {
                cities.add(new City(fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), fields[5]));
            } catch (ArrayIndexOutOfBoundsException e) {
                cities.add(new City(fields[1], fields[2], fields[3], Integer.parseInt(fields[4])));
            }
        }

        for (City city: cities){
            System.out.println(city);
        }

        System.out.println(cities.size());
    }
}