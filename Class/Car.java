public class Car {

    // declaring variables

    int speed;
    String name;

    // constructor

    public Car(String name ,int speed) {
        this.name = name;
        this.speed = speed;
    }

    // copy constructor

    public Car(Car c) {
        this.name = c.name;
        this.speed = c.speed;
    } 

    // function

    public void display() {
        System.out.println("car name: " + name + "\t car speed: " + speed);
    }

}
