package com.tlquick.utils;

import java.util.LinkedList;

public class Entities 
{
    protected LinkedList<Entity> entities = new LinkedList<Entity>();
    protected String result = "";
  
    public Entities()
    {  
    }
    public void spin()
    {
        resetSpin();
    }
    public String getResult()
    {
        for (Entity entity : entities)
        {
            result += entity.toString();
        } 
        return result;
    }
    protected void resetSpin()
    {
        result = "";
    }
    public int size()
    {
        return entities.size();
    }
    public String toString()
    {
        return result;
    }
}

