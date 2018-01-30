package lessons.interihance;

/**
 * Created by nazar123 on 30.01.2018.
 */
public class Triangle  extends Figure{

    public Triangle(int length, int height, String nameOfFigure) {
        super(length, height,nameOfFigure);
    }

    @Override
    public int calculateSquare(){
        return    getHeight()*getLength()/2;
    }


}
