package com.rudenko.programmingChallenge.writer.entities;

import java.io.Serializable;

/**
 * Entety field of challengeObject
 * <p/>
 * Created by Zursmandtor_PC on 08.12.2014.
 */
public class Field implements Serializable {

    /**
     * Fields type
     */
    private int typeOfField;

    /**
     * Contents of field
     */
    private String symbols;

    /**
     * The number of characters of the field
     */
    private int symbolCount;

    /**
     * Creates Field instance without parameters
     */
    public Field() {
    }

    /**
     * Creates Field instance with specified fields
     *
     * @param typeOfField - type of Field
     * @param symbols     - contents of field
     * @param symbolCount - the number of characters of the field
     */
    public Field(int typeOfField, String symbols, int symbolCount) {
        this.typeOfField = typeOfField;
        this.symbols = symbols;
        this.symbolCount = symbolCount;
    }

    /**
     * Creates Field instance with specified fields
     *
     * @param typeOfField - type of Field
     * @param symbols     - contents of field
     */
    public Field(String symbols, int typeOfField) {
        this.symbols = symbols;
        this.typeOfField = typeOfField;
    }


    /**
     * Get type of field
     *
     * @return type of field
     */
    public int getTypeOfField() {
        return typeOfField;
    }

    /**
     * Set type of field
     *
     * @param typeOfField type of field
     */
    public void setTypeOfField(int typeOfField) {
        this.typeOfField = typeOfField;
    }

    /**
     * Get contents of field
     *
     * @return contents of field
     */
    public String getSymbols() {
        return symbols;
    }

    /**
     * Set contents of field
     *
     * @param symbols contents of field
     */
    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }

    /**
     * Get the number of characters of the field
     *
     * @return the number of characters of the field
     */
    public int getSymbolCount() {
        return symbolCount;
    }

    /**
     * Set the number of characters of the field
     *
     * @param symbolCount the number of characters of the field
     */
    public void setSymbolCount(int symbolCount) {
        this.symbolCount = symbolCount;
    }

    @Override
    public String toString() {
        return "Field{" +
                "symbols='" + symbols + '\'' +
                ", typeOfField='" + typeOfField + '\'' +
                '}';
    }
}
