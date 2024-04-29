package com.DiceRoll.slot;

public class Request {
    private double balance;
    private double bet;
    private int numOfDices;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public int getNumOfDices() {
        return numOfDices;
    }

    public void setNumOfDices(int numOfDices) {
        this.numOfDices = numOfDices;
    }
}
