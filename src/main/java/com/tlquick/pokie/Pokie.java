package com.tlquick.pokie;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import com.tlquick.utils.Symbol;

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
    private int betLines = 1;
    private String DEFAULT_MSG = "Press Spin";
    private String msg = DEFAULT_MSG;
   
    
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
        double wager = player.getBet()* betLines;
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
        payouts += amount;
        if ( amount > 0)
            setMsg("Congratulations! You won $" + ((int)amount));
        else
        	setMsg(DEFAULT_MSG);
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
    public int turnover()
    {
        return (int)turnover;
    }
    public int payouts()
    {
        return (int)payouts;
    }
    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    public void show()
    {
        System.out.println(toString());
    }
    public String toString()
    {   
        String s = "Cherry Bomb:";
        s += " payouts = $" + payouts;
        s += " turnover = $" + turnover;
        s += " spins = " + spins;
        s += "\n" + player.toString();
        return s;   
    }
}

