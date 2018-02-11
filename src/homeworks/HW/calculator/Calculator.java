package homeworks.HW.calculator;

import java.util.Random;

/**
 * Created by nazar123 on 06.02.2018.
 */
public class Calculator {
    Random rand = new Random();

    public int multiplyNumbers(){
        return returnAnyNumberA() * returnAnyNumberB();
    }

    public double divideNumbers(){
        return returnAnyNumberA() / returnAnyNumberB();
    }

    public int subtractNumbers(){
        return returnAnyNumberA() - returnAnyNumberB();
    }

    public int addNumbers(){
        return returnAnyNumberA() + returnAnyNumberB();
    }

    public int calculateProcentFromNumbers(){
        return returnAnyNumberA() % returnAnyNumberB();
    }
    public int returnAnyNumberA(){
        return rand.nextInt(100) + 1;
    }

    public int returnAnyNumberB(){
        return rand.nextInt(100) + 1;
    }

    public static void main(String[] args) {

        Calculator c = new Calculator();

        int a = c.returnAnyNumberA();


    }
}
