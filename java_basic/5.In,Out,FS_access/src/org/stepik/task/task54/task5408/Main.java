package org.stepik.task.task54.task5408;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int count = objectInputStream.readInt();
            animals = new Animal[count];
            for (int i = 0; i < count; i++) {
                animals[i] = (Animal) objectInputStream.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return animals;
    }
}
