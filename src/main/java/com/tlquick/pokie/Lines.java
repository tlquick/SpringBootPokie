package com.tlquick.pokie;

import org.springframework.stereotype.Component;

import com.tlquick.utils.Entities;
import com.tlquick.utils.Entity;
import com.tlquick.utils.Symbol;
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
    public String[][]  getResultImages()
    {
    	String [][] images = new String[NUMBER_OF_LINES][NUMBER_OF_REELS];
        //tokenise and set all chars to images
        for(int i = 0; i < size(); i++)//for each line
        {
            String lineResult = getResult(i); //has 3 reel results - use charAt()
            for(int j = 0; j < lineResult.length(); j++)
            {
                images[i][j] = getImage("" + lineResult.charAt(j));
            }
        }
        return images;
    }
    private String getImage(String result)//lookup symbol and find the image to show
    {
        for(Symbol symbol : Symbol.values())
        {
            if(symbol.getName().equals(result))
                return symbol.getImage();
        }
        return "";
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
