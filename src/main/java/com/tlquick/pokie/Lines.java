package com.tlquick.pokie;

import org.springframework.stereotype.Component;

import com.tlquick.utils.Entities;
import com.tlquick.utils.Entity;
@Component
public class Lines extends Entities
{
    private final int NUMBER_OF_REELS = 3;
    private final int NUMBER_OF_LINES = 3;
    private Reels reels;

    public Lines()
    {
    	int number = NUMBER_OF_LINES;
        for (int i = 0; i < number; i++)
        {
           entities.add(new Line(i));
        }
        reels = new Reels(NUMBER_OF_REELS, number);
    }
    public void spin()
    {
        resetSpin();
        reels.spin();
        for (Entity line : entities)
        {
          ((Line)line).spin(reels);
           result += line.toString() + "\n";
        }     
    }
    public String getResult(int number)
    {    
        return ((Line)entities.get(number)).toString();
    }
    public String getResult()
    {
        return result;
    }
    public int payOff(int betLines)
    {
        int payoff = 0;
        for (Entity line : entities)
        {
            if(((Line)line).getNumber() < betLines)
                payoff += ((Line)line).payOff();
        }
        return payoff;
    }
}
