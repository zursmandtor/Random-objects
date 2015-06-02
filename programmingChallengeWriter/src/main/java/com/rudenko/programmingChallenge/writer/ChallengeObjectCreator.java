package com.rudenko.programmingChallenge.writer;


import com.rudenko.programmingChallenge.writer.entities.ChallengeObject;
import com.rudenko.programmingChallenge.writer.entities.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creating an object of ChallengeObject in a random order
 */
public class ChallengeObjectCreator {

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
     * Next symbol code
     */
    int vRes;

    /**
     * Byte counter
     */
    int vCounterSizeOfFile = 0;

    /**
     * Spaces for alphanumerical
     */
    int vSpace = 0;

    /**
     * Intermediate code symbol
     */
    int vSymbol = 0;

    /**
     * Size of ChallengeObject (bytes)
     */
    int SizeOf = 10485760;

    /**
     * the decimal point position for real
     */
    int vDotPosition = 0;

    /**
     * Random object
     */
    Random rand = new Random();


    /**
     * The process of generating random variations of the field
     *
     * @param typeOfField - type of field
     * @return Field object
     */
    public Field createField(int typeOfField) {
        StringBuilder builder = new StringBuilder();
        Field resultField = new Field();
        resultField.setSymbolCount(rand.nextInt(20));
        int j = 0;
        switch (typeOfField) {
            case ALPHABETICAL:
                while (j <= resultField.getSymbolCount()) {
                    vSymbol = rand.nextInt(0x1A);
                    char curChar = (char) (vSymbol + 0x61);
                    builder.append(curChar);
                    ++j;
                }
                resultField.setSymbols(builder.toString());
                resultField.setTypeOfField(typeOfField);
                break;
            case REAL: {
                if (resultField.getSymbolCount() > 2) vDotPosition = rand.nextInt(resultField.getSymbolCount() - 2) + 1;
                while (j < resultField.getSymbolCount()) {
                    vSymbol = rand.nextInt(0xA);
                    char curChar = (char) (vSymbol + 0x30);
                    if (vDotPosition == j) {
                        curChar = (char) 0X2E;
                    }
                    builder.append(curChar);
                    ++j;
                }
            }
            resultField.setSymbols(builder.toString());
            resultField.setTypeOfField(typeOfField);
            break;
            case INTEGER:
                while (j <= resultField.getSymbolCount()) {
                    vSymbol = rand.nextInt(0xA);
                    char curChar = (char) (vSymbol + 0x30);
                    builder.append(curChar);
                    ++j;
                }
                resultField.setSymbols(builder.toString());
                resultField.setTypeOfField(typeOfField);
                break;
            case ALPHANUMERICAL: {
                char curChar = 0;
                vSpace = rand.nextInt(10);
                for (int i = 0; i <= vSpace; i++) {
                    curChar = (char) (0x20);
                    builder.append(curChar);
                }
                while (j <= resultField.getSymbolCount()) {

                    vSymbol = rand.nextInt(0x24); // а для альфанумерик нужно все.
                    if (vSymbol <= 9) vRes = vSymbol + 0x30;
                    else vRes = vSymbol + 0x57;//тут нюансик - цифры и буквы делаются по-разному.
                    curChar = (char) (vRes);
                    builder.append(curChar); //добавляем символ в стрингбилдер
                    ++j;
                }
                vSpace = rand.nextInt(10);
                for (int i = 0; i <= vSpace; i++) {
                    curChar = (char) (0x20);
                    builder.append(curChar);
                }
            }

            resultField.setSymbols(builder.toString());
            resultField.setTypeOfField(typeOfField);
            break;
        }
        return resultField;
    }


    /**
     * Adding fields to the object ChallengeObject until vCounterSizeOfFile<=SizeOf
     *
     * @return object of ChallengeObject
     */
    public ChallengeObject createObject() {
        List<Field> fields = new ArrayList<Field>();
        while (vCounterSizeOfFile <= SizeOf) {
            int typeOfField = rand.nextInt(5);
            Field currentField = createField(typeOfField);
            fields.add(currentField);
            vCounterSizeOfFile += (currentField.getSymbolCount()) * 2;
        }
        ChallengeObject currentChallengeObject = new ChallengeObject(fields);
        return currentChallengeObject;
    }


}
