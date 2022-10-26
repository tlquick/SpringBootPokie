package com.tlquick.utils;

public class Entity
{
    protected int number;
    public Entity(int number)
    {
        this.number = number;
    }
    public void setNumber(int number)
    {
    	this.number = number;
    }
    public int getNumber()
    {
        return number;
    }
    public String toString()
    {
        return "" + number;
    }
}
