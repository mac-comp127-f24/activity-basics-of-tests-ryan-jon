package testingbasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roshambo {
    // The three possible hand shapes
    public static final String
        ROCK = "o",
        PAPER = "_",
        SCISSORS = "X";

    /**
     * Plays one round of a Roshambo tournament, where all players make hand signs, then each player
     * takes the hand sign of the player on their left if that player's sign beat their own.
     * 
     * @param handShapes The hand shapes of the players, with the first considered to be next to the
     *                   last (because the players are in a circle).
     * @return  A new list with the hand shapes for the next round.
     */
    public static List<String> playOneRound(List<String> handShapes) {
        playOneRound(ROCK) → returns new hand shapes
        shapeToLeft ← last element of handShapes
        result ← new empty mutable list
        for each handShape in handShapes:
            call compareShapes(shapeToLeft, handShape)
            if shapeToLeft wins
                add shapeToLeft to results
            else
                add handShape to results
            // This player's shape becomes the shape
            // to the left of the next player
            shapeToLeft ← handShape
        return result

    }

    /**
     * Determines who wins in a 2-player game of Roshambo.
     * 
     * @param shape1 One of ROCK, PAPER, or SCISSORS.
     * @param shape2 One of ROCK, PAPER, or SCISSORS.
     * @return -1 if shape1 wins, 1 if shape2 wins, or 0 if it was a tie.
     */
    public static int compareShapes(String shape1, String shape2) {
        if (shape2.equals(shape1)) {
            return 0;
        }
        if (
            shape2.equals(SCISSORS) && shape1.equals(PAPER)
            || shape2.equals(PAPER) && shape1.equals(ROCK)
            || shape2.equals(ROCK) && shape1.equals(SCISSORS)
        ) {
            return 1;
        } else {
            return -1;
        }
    }


}
