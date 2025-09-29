// A software company is developing a vehicle management system. As 
// part of this system, they have created a class named Car to represent 
// basic car information. The design of the class uses constructor 
// overloading.
// The class includes:
// • A no-argument constructor,
// • A one-argument constructor (brand),
// • A three-argument constructor (brand, model, year).
// • A method displayInfo() to print the car's details.
// The constructors are designed to call each other using the this()
// keyword.
class Car {
    String brand;
    String model;
    int year;

    Car() {
        this("Unknown");
    }

    Car(String brand) {
        this(brand, "Not specified", 0);
    }

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car("land rover");
        Car c3 = new Car("Hyundai", "Creta", 2024);

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
    }
}