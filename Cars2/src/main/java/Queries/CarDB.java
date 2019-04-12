package Queries;

import Connection.Connect;
import DBClasses.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CarDB {
    public static ArrayList<Car> select() {

        ArrayList<Car> Cars = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = Connect.getConnect()) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM t_cars");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String brand = resultSet.getString(2);
                    int user_id = resultSet.getInt(3);
                    Car car = new Car(id, brand, user_id);
                    Cars.add(car);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return Cars;
    }

    public static int insert(Car car) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = Connect.getConnect()) {

                String sql = "INSERT INTO t_cars (car_brand, car_user_id) Values ( ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, car.getBrand());
                    preparedStatement.setInt(2, car.getUserId());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = Connect.getConnect()) {

                String sql = "DELETE FROM t_cars WHERE id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Car car) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = Connect.getConnect()) {

                String sql = "UPDATE t_cars SET car_brand = ?, car_user_id = ? WHERE car_id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, car.getBrand());
                    preparedStatement.setInt(2, car.getUserId());
                    preparedStatement.setInt(3, car.getId());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
    public static Car selectOne(int id) {

        Car car = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = Connect.getConnect()){

                String sql = "SELECT * FROM t_cars WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int car_id = resultSet.getInt(1);
                        String brand = resultSet.getString(2);
                        int user_id = resultSet.getInt(3);
                        car = new Car(car_id, brand, user_id);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return car;
    }
}
