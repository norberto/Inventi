package lt.inventi.playground.beans;

import java.util.Random;

/**
 * Created by GreenFigure on 5/19/2015.
 */
public class RandomGenerator {
    public int out(int max){
        return new Random().nextInt(max);
    }
}