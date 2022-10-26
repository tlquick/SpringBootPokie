package com.tlquick.pokie;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class Pokie
{

    private int spins = 0;
    private double turnover = 0.0;
    private double payouts = 0.0;
    @Autowired
    private Player player;
    @Autowired
    private Lines lines;
    private int betLines;

   
    public void addCredit(double amount)
    {
        player.updateBalance(amount);
    }
    public void bet(int amount)
    {
        player.setBet(amount);
    }
    public void betLines(int lines)
    {
        betLines = lines;
    }
    public void spin()
    {
        double wager = player.getBet()*betLines;
        player.placeBet(wager);
        turnover += wager;
        spins ++;
        lines.spin();     
    }
    public String getResult()
    {
        return lines.getResult();
    }
    public void payOut()
    {
        double amount = player.payout(lines.payOff(betLines));
        player.updateBalance(amount);
        payouts +=amount;
    }
    public double getPayOut()
    {
        return player.payout(lines.payOff(betLines));
    }
    public void collect()
    {   
        player.collect();
    }  
    public Player player()
    {
        return player;
    }
    public Lines lines()
    {
        return lines;
    }
    public int getBetLines()
    {
        return betLines;
    }
    public int spins()
    {
        return spins;
    }
    public double turnover()
    {
        return turnover;
    }
    public double payouts()
    {
        return payouts;
    }
    public void show()
    {
        System.out.println(toString());
    }
    public String toString()
    {   
        String s = "Pokie Bandit:";
        s += " payouts = $" + payouts;
        s += " turnover = $" + turnover;
        s += " spins = " + spins;
        s += "\n" + player.toString();
        return s;   
    }
}

