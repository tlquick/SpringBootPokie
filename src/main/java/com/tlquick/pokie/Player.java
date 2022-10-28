package com.tlquick.pokie;

import org.springframework.stereotype.Component;

@Component
public class Player 
{
    private double balance = 0.0;
    private double bet = 1.0;
    private int games = 0;

    public boolean canBet(int lines)
    {
        return balance >= bet*lines;
    }
    public void placeBet(double betAmount)
    {
        balance -= betAmount;
        games++;
    }
    public double payout(double amount)
    {
        return bet * amount;
    }
    public void collect()
    {
        balance = 0;
        games = 0;
    }
    public void updateBalance(double amount)
    {
        balance += amount;
    }
    public void setBet(double bet)
    {
        this.bet = bet;
    }
    public double getBet()
    {
        return bet;
    }
    public double getBalance()
    {
        return balance;
    }
    public int getGames()
    {
        return games;
    }
    public String toString()
    {
        return "Player: bet $" + bet + " balance $" + balance + " games played " + games;
    }
}

