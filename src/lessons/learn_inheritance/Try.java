package lessons.learn_inheritance;


public class Try {

    private Car car;

    public Try(Car car) {
        this.car = car;
    }

    /* private Bmw car;
    private Mercedes mercedes;

    public Try(Bmw car) {
        this.car = car;
    }

    public Try(Mercedes car) {
        this.mercedes = car;
    }*/

    public void print() {
        System.out.println(car.getModel());
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Bmw car) {
        this.car = car;
    }
}
