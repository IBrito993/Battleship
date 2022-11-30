class Car {

    public int yearModel;
    public String make;
    public int speed;

    public Car() {
    }

    public Car(int yearModel, String make, int speed) {
        this.yearModel = yearModel;
        this.make = make;
        this.speed = speed;
    }

    public void brake() {
        if (this.speed > 4) {
            this.speed -= 5;
        } else {
            this.speed = 0;
        }
    }

    public void accelerate() {
        this.speed += 5;
    }
}