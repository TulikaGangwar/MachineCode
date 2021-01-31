package com.tulika.SnakeandLadder.core;

import com.tulika.SnakeandLadder.models.Board;
import com.tulika.SnakeandLadder.models.Ladder;
import com.tulika.SnakeandLadder.models.Player;
import com.tulika.SnakeandLadder.models.Snake;

import java.util.*;

public class SnakeAndLadderBoardService
{
    int current_no_of_Players;
    int initial_no_of_Players;
    Queue<Player> playerQueue= new LinkedList<>();
    RollDice rollDice;
//set locations of Snakes
Board board;
    public void setSnakes(ArrayList<Snake> snakesPositions)
{
   HashMap<Integer,Integer> snakePositionsMapped= new HashMap<Integer,Integer>();
   for(Snake snake:snakesPositions)
   {
       snakePositionsMapped.put(snake.getStart(),snake.getEnd());
   }
   board.setSnakeLocation(snakePositionsMapped);
}

//set locations of ladders
public void setLadders(ArrayList<Ladder> laddersPositions)
{
    HashMap<Integer,Integer> laddersPositionMapped= new HashMap<Integer,Integer>();
    for(Ladder ladder:laddersPositions)
    {
        laddersPositionMapped.put(ladder.getStart(),ladder.getEnd());
    }
    board.setladderLocation(laddersPositionMapped);
}

//set locations of players
public void setPlayers(ArrayList<Player> playersPositions)
{
    HashMap<String,Integer> playersPositionMapped= new HashMap<String,Integer>();
    for(Player player:playersPositions)
    {
        playersPositionMapped.put(player.getId(),0);
    }
    board.setPlayerPositions(playersPositionMapped);
}
public boolean isGameFinished()
{
    current_no_of_Players=playerQueue.size();
    if(current_no_of_Players<initial_no_of_Players)
    {
        return true;
    }

        return false;

}

public int valueAfterDiceRoll()
    {
        return rollDice.getDiceRoll();
    }

public int positionAfterAllSnakesAndLadders(int previousPosition,Player currentPlayer)
{
    int newPosition=0;

          while(board.getladderLocation().containsKey(previousPosition))
          {
          newPosition = board.getladderLocation().get(previousPosition);
          previousPosition=newPosition;
          }
    while(board.getSnakeLocation().containsKey(previousPosition))
    {
        newPosition = board.getSnakeLocation().get(previousPosition);
        previousPosition=newPosition;
    }
    board.getPlayerPositions().replace(currentPlayer.getId(),newPosition);

    return newPosition;
}
public int getNewPlayerPosition(Player currentPlayer,int diceRoll)
    {
        int newPlayerPosition;

        int currentPlayerPosition=board.getPlayerPositions().get(currentPlayer.getId());
        newPlayerPosition=currentPlayerPosition+diceRoll;
        int board_size=board.getSize();
        if(newPlayerPosition<=board_size)
        {
            newPlayerPosition=positionAfterAllSnakesAndLadders(newPlayerPosition,currentPlayer);
        }
        else {
            newPlayerPosition=currentPlayerPosition;
        }

        return newPlayerPosition;

    }
    public boolean hasPlayerWon(Player currentPlayer)
    {
        int playerPosition=board.getPlayerPositions().get(currentPlayer.getName());
        if(playerPosition==board.getSize())
        {
            return true;
        }
        return false;
    }
public void startGame()
{
    while(!isGameFinished())
    {
     int diceRoll=valueAfterDiceRoll();
     Player currentPlayer=playerQueue.poll();
     getNewPlayerPosition(currentPlayer,diceRoll);
     if(hasPlayerWon(currentPlayer))
     {
         System.out.println("Player"+" "+currentPlayer.getName()+" has won the game");
         break;
     }
     playerQueue.add(currentPlayer);

    }

}

}
