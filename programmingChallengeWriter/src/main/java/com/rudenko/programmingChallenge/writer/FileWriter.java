package com.rudenko.programmingChallenge.writer;

import com.rudenko.programmingChallenge.writer.entities.ChallengeObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Writing an object of ChallengeObject to a file
 */
public class FileWriter {

    /**
     * Create ChallengeObjectCreator object
     */
    ChallengeObjectCreator challengeObjectCreator = new ChallengeObjectCreator();

    /**
     * Create ChallengeObject object
     */
    ChallengeObject challengeObject = challengeObjectCreator.createObject();

    /**
     * Creates FileWriter instance without parameters
     */
    public FileWriter() {
    }


    /**
     * Write symbols of ChallengeObjects object to the file
     */
    public void writeObject() {
        try {
            File file = new File("E://programmingChallenge.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, true));
            objectOutputStream.writeObject(challengeObject);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
