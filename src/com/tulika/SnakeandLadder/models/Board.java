package com.tulika.SnakeandLadder.models;

import java.util.HashMap;

public class Board {
    private int size;
    private HashMap<Integer,Integer> snakeLocator ;
    private HashMap<Integer,Integer> ladderLocator ;
    private HashMap<String,Integer> playerPositions ;
    //board dimensions
    public Board(int size)
    {
        this.size=size;
        this.snakeLocator= new HashMap<Integer,Integer>();
        this.ladderLocator= new HashMap<Integer,Integer>();
        this.playerPositions=new HashMap<String,Integer>();
    }
    public int getSize()
    {
        return size;
    }

    //snake locations
    public HashMap<Integer,Integer> getSnakeLocation()
    {
        return snakeLocator;
    }
    public void setSnakeLocation(HashMap<Integer, Integer> snakeLocator)
    {
        this.snakeLocator=snakeLocator;
    }

    //ladder locations
    public HashMap<Integer,Integer> getladderLocation()
    {
        return ladderLocator;
    }
    public void setladderLocation(HashMap<Integer,Integer> ladderLocator)
    {
        this.ladderLocator=ladderLocator;
    }

    //players location
    public void setPlayerPositions(HashMap<String,Integer>playerPositions)
    {
        this.playerPositions=playerPositions;

    }

    public HashMap<String,Integer> getPlayerPositions()
    {
        return playerPositions;
    }

}
