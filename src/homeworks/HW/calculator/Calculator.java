package homeworks.HW.calculator;

import java.util.Random;

/**
 * Created by nazar123 on 06.02.2018.
 */
public class Calculator {
    public static final Random RAND = new Random();

    public int multiplyNumbers() {
        return returnAnyNumberA() * returnAnyNumberB();
    }

    public int multiplyNumbersPrivate() {
        return returnAnyNumberC() * returnAnyNumberD();
    }

    public double divideNumbers() {
        return returnAnyNumberA() / returnAnyNumberB();
    }

    public int subtractNumbers() {
        return returnAnyNumberA() - returnAnyNumberB();
    }

    public int addNumbers() {
        return returnAnyNumberA() + returnAnyNumberB();
    }

    public int calculateProcentFromNumbers() {
        return returnAnyNumberA() % returnAnyNumberB();
    }

    private int returnAnyNumberC() {
        return RAND.nextInt(100) + 1;
    }

    private int returnAnyNumberD() {
        return RAND.nextInt(100) + 1;
    }

    public static int returnAnyNumberA() {
        return RAND.nextInt(100) + 1;
    }

    public static int returnAnyNumberB() {
        return RAND.nextInt(100) + 1;
    }


    public static void main(String[] args) {

        Calculator c = new Calculator();

        int a = c.returnAnyNumberA();


    }
}
