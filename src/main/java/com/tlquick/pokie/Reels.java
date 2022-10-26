package com.tlquick.pokie;

import com.tlquick.utils.Entities;
import com.tlquick.utils.Entity;


public class Reels extends Entities
{    
    public Reels(int number, int lines)
    {
        super();
        for (int i = 0; i < number; i++)
        {
           entities.add(new Reel(i, lines));
        }
    }
    public void spin()
    {
        for(Entity reel : entities)
        {
            ((Reel)reel).spin();
        }
    }
    public String getResult(int line)
    {
        String result = "";
        for(Entity reel : entities)
        {
            result += ((Reel)reel).getResult(line);
        }
        return result;
    }
}

