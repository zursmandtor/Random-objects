package com.rudenko.programmingChallenge.reader;


import com.rudenko.programmingChallenge.writer.entities.ChallengeObject;
import com.rudenko.programmingChallenge.writer.entities.Field;

import java.io.*;
import java.util.List;

/**
 * Reading an object of ChallengeObject to a file
 */
public class FileReader {

    /**
     * Type of field alphabetical strings
     */
    public static final int ALPHABETICAL = 1;

    /**
     * Type of field real numbers
     */
    public static final int REAL = 2;

    /**
     * Type of field integers
     */
    public static final int INTEGER = 3;

    /**
     * Type of field alphanumerics
     */
    public static final int ALPHANUMERICAL = 4;


    /**
     * Reading file and output the results to the console in a predetermined order
     */
    public void readObject() {

        File file = new File("E://programmingChallenge.txt");
        ObjectInputStream objectInputStream = null;


        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            ChallengeObject newChallengeObject;
            while ((newChallengeObject = (ChallengeObject) objectInputStream.readObject()) != null) {
                List<Field> fields = newChallengeObject.getFields();
                Field field;
                for (int i = 0; i < fields.size(); i++) {
                    field = fields.get(i);
                    if (field.getTypeOfField() == ALPHABETICAL) {
                        System.out.println(field.getSymbols() + " - alphabetical strings");
                    } else if (field.getTypeOfField() == REAL) {
                        System.out.println(field.getSymbols() + " - real numbers");
                    } else if (field.getTypeOfField() == INTEGER) {
                        System.out.println(field.getSymbols() + " - integer");
                    } else if (field.getTypeOfField() == ALPHANUMERICAL) {
                        String symbols = field.getSymbols();
                        String newSymbols = symbols.replaceAll(" ", ""); //удаляем все пробелы
                        System.out.println(newSymbols + " - alphanumeric");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
