package com.esof322.pa2;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Player {
    
    
    private int piece;    
    private int balance;  
    private int goCounter;
    private int position;
    private int doublesCounter;
    
    
    
    private List<PropertySpace> ownedPropertySpaces; 
    private List<Die> dice; 
    private Space currentSpace;
    private Banker bank;
    
    
    
    private int getPiece() {
        return this.piece;
    }
    
    
    private void setPiece(int piece) {
        this.piece = piece;
    }
    
    
    protected int getBalance() {
        return this.balance;
    }
    
    
    private void setBalance(int balance) {
        this.balance = balance;
    }
    
    
    private int getGoCounter() {
        return this.goCounter;
    }
    
    
    private void setGoCounter(int goCounter) {
        this.goCounter = goCounter;
    }
    
    
    private int getPosition() {
        return this.position;
    }
    
    
    private void setPosition(int position) {
        this.position = position;
    }
    
    
    private int getDoublesCounter() {
        return this.doublesCounter;
    }
    
    
    private void setDoublesCounter(int doublesCounter) {
        this.doublesCounter = doublesCounter;
    }
    

    //                          Operations                                  
    
    
    public void mortgage() {
        //TODO
    }
    
    
    public void unMortgage() {
        //TODO
    }
    
    
    public void takeTurn() {
        //TODO
    }
    
    
    private int rollDice() {
        //TODO
        return 0;
    }
    
    
    protected void movePlayer(int spaces) {
        //TODO
    }
    
    
    public void upgrade(PropertySpace space) {
        //TODO
    }
    
    
    public void purchase(PropertySpace space) {
        //TODO
    }
    
    
}
