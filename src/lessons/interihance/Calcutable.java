package lessons.interihance;

/**
 * Created by nazar123 on 30.01.2018.
 */
public interface Calcutable {

    public int calculateSquare();

    public default void print(){
        System.out.println("The square of figure is "+ calculateSquare());
    }
}
