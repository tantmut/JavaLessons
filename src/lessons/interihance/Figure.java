package lessons.interihance;

/**
 * Created by nazar123 on 30.01.2018.
 */
public abstract class Figure implements Calcutable {

    private int length;
    private int height;
    private String nameOfFigure;

    @Override
    public void print(){
        System.out.println("The square of "+getNameOfFigure()+ " is "+ calculateSquare());
    }

    public String getNameOfFigure() {
        return nameOfFigure;
    }
    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Figure(int length, int height,String nameOfFigure) {
        this.length = length;
        this.height = height;
        this.nameOfFigure = nameOfFigure;
    }

    public static void main(String[] args) {

        Figure triangle = new Triangle(8,4, "triangle");
        Figure parallelogram = new Parallelogram(15,17, "parallelogram");
        Figure romb = new Romb(24,9, "romb");

        triangle.calculateSquare();
        parallelogram.calculateSquare();
        romb.calculateSquare();

        triangle.print();
        parallelogram.print();
        romb.print();

    }
}


