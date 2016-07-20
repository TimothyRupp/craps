package com.timothy_g.craps;

import java.security.SecureRandom;

public class Craps
{
    //create a secure random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();

    //enum type with constants representing the status of the game
    private enum Status { CONTINUE, WON, LOST };

    //constants representing the common rolls of the dice
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    //plays a single game of craps
    public static void main(String[] args) {

        int myPoint = 0; //point if no win or loss on first roll
        Status gameStatus; //can contain on of the enum Status conditions

        int sumOfDice = rollDice();  //first roll

        //determine game status and point based on first roll
        switch (sumOfDice) {
            case SEVEN:  //winner winner chicken dinner
            case YO_LEVEN: //winner
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES: //craps
            case TREY:  //craps
            case BOX_CARS:  //craps
                gameStatus = Status.LOST;
                break;
            default:  //not a win nor a loss, remember the point
                gameStatus = Status.CONTINUE;  //game not over
                myPoint = sumOfDice;  //remember the point of the shooter
                System.out.printf("Shooter's point is %d%n", myPoint);
                break;
        }

        //while the game continues
        while (gameStatus == Status.CONTINUE) // not WON or LOST
        {
            sumOfDice = rollDice(); //roll again

            //determine status after roll
            if (sumOfDice == myPoint)
                gameStatus = Status.WON;
            else if (sumOfDice == SEVEN)
                gameStatus = Status.LOST;
        }
            if (gameStatus == Status.WON)
                System.out.println("Shooter wins");
            else
                System.out.println("Craps shooter loses");
    }

        //roll dice, calculate sum and display results
        public static int rollDice() {

            int die1 = 1 + randomNumbers.nextInt(6);
            int die2 = 1 + randomNumbers.nextInt(6);

            int sum = die1 + die2;

            //display the roll result
            System.out.printf("Shooter's roll %d + %d = %d%n", die1, die2, sum);
            return sum;
        }

} //end class






