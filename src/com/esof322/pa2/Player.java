package com.esof322.pa2;

import java.util.Set;
import java.util.HashSet;

public class Player {
    
    
    private Integer piece;
    
    
    private Integer balance;
    
    
    private Integer goCounter;
    
    
    private Integer position;
    
    
    private Integer doublesCounter;
    
    
    
    private Set<PropertySpace> propertySpaces;
    
    
    private Set<Die> die;
    
    
    private Space currentSpace;
    
    
    private Banker bank;
    
    
    
    private Integer getPiece() {
        return this.piece;
    }
    
    
    private void setPiece(Integer piece) {
        this.piece = piece;
    }
    
    
    protected int getBalance() {
        return this.balance;
    }
    
    
    private void setBalance(Integer balance) {
        this.balance = balance;
    }
    
    
    private Integer getGoCounter() {
        return this.goCounter;
    }
    
    
    private void setGoCounter(Integer goCounter) {
        this.goCounter = goCounter;
    }
    
    
    private Integer getPosition() {
        return this.position;
    }
    
    
    private void setPosition(Integer position) {
        this.position = position;
    }
    
    
    private Integer getDoublesCounter() {
        return this.doublesCounter;
    }
    
    
    private void setDoublesCounter(Integer doublesCounter) {
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
