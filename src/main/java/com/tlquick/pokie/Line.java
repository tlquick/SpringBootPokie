package com.tlquick.pokie;

import com.tlquick.utils.Entity;

import com.tlquick.utils.Symbol;

public class Line extends Entity
{
   private String result = "JJJ";

   public Line(int number)
   {
       super(number);
   }
   public void spin(Reels reels)
   {         
       result = reels.getResult(number);
   }
   public int payOff()
   {
       int payoff = 0;
       for (Symbol symbol: Symbol.values())
       {
           if (result.equals(symbol.getWin()))
               payoff = symbol.getPayoff();
       }
       return payoff;
   }
   public String toString()
   {
       return result;
   }
}

