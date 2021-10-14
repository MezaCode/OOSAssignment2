package src.controller;

/**
 * WarType.java
 *
 * @author Mazen Shaban
 *
 * WarType is an interface used for implementation of different types of rules for the card game "War".
 * It sets the default functionality that each rule type must adhere to inorder for it to be pluggable
 * into the rest of the program.
 */
public interface WarType {

    private void initialize(){}

    /**
     * Used to start a game
     */
    public void play();
}