package org.example.glav5.part4;

import java.io.*;

public class Main {

    public static Animal[] deserializeAnimalArray(byte[] data) {
        int countAnimals = 0;

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            countAnimals = ois.readInt();

            Animal[] animals = new Animal[countAnimals];
            for (int i = 0; i < countAnimals; i++) {
                animals[i] = (Animal) ois.readObject();
            }
            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException("parsing error");
        }
    }

}
