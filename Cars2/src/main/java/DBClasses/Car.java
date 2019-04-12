package DBClasses;


public class Car {
    private int id;
    private String brand;
    private int user_id;

    public Car() {
    }

    public Car(String brand, int user_id) {

        this.brand = brand;
        this.user_id = user_id;
    }

    public Car(int id, String brand, int user_id) {
        this.id = id;
        this.brand = brand;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
}
