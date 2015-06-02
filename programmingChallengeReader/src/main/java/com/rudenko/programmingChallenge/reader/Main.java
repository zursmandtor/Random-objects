package com.rudenko.programmingChallenge.reader;


import com.rudenko.programmingChallenge.writer.FileWriter;

/**
 * The entry point to the program
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Create FileWriters object
         */
        FileWriter fileWriter = new FileWriter();

        /**
         * Call method writeObject FileWriters object
         */
        fileWriter.writeObject();

        /**
         * Create FileReaders object
         */
        FileReader fileReader = new FileReader();

        /**
         * Call method readObject FileReaders object
         */
        fileReader.readObject();
    }
}
