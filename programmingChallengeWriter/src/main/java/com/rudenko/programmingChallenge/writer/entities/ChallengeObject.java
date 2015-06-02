package com.rudenko.programmingChallenge.writer.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entety ChalengeObject - contains all of the characters to be written to a file
 */
public class ChallengeObject implements Serializable {

    /**
     * List of enteties Field
     */
    private List<Field> fields = new ArrayList<Field>();

    /**
     * Creates ChallengeObject instance without parameters
     */
    public ChallengeObject() {
    }

    /**
     * Creates ChallengeObject instance with specified fields
     *
     * @param fields - list of Fields
     */
    public ChallengeObject(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * Get list of Fields
     *
     * @return list of Fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * Set list of Fields
     *
     * @param fields - list of Fields
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "ChallengeObject{" +
                "fields=" + fields +
                '}';
    }
}
