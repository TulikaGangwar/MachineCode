package com.tulika.SnakeandLadder;

import com.tulika.SnakeandLadder.core.SnakeAndLadderBoardService;
import com.tulika.SnakeandLadder.models.Ladder;
import com.tulika.SnakeandLadder.models.Player;
import com.tulika.SnakeandLadder.models.Snake;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        //input snakes
        int no_of_Snakes= s.nextInt();
        SnakeAndLadderBoardService snakeAndLadderBoardService= new SnakeAndLadderBoardService();
        ArrayList<Snake> snakesPositions= new ArrayList<>();
        for(int i=0;i<no_of_Snakes;i++)
        {
            snakesPositions.add(new Snake(s.nextInt(),s.nextInt()));
        }

        snakeAndLadderBoardService.setSnakes(snakesPositions);

        //input Ladders
        ArrayList<Ladder> ladderPositions= new ArrayList<>();
        int no_of_Ladders= s.nextInt();
        for(int i=0;i<no_of_Ladders;i++)
        {
            ladderPositions.add(new Ladder(s.nextInt(),s.nextInt()));
        }
        snakeAndLadderBoardService.setLadders(ladderPositions);

        //input Players
        ArrayList<Player> playerpositions= new ArrayList<>();
       int no_of_Players=s.nextInt();
        for(int i=0;i<no_of_Players;i++)
        {
            playerpositions.add(new Player(s.next()));
        }
        snakeAndLadderBoardService.setPlayers(playerpositions);





    }
}
