package units;

/**
 * Created by Egor on 05.10.2017.
 */

public class Student extends Person {

    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Student(String firstName, String lastName, int year, double rating) {
        super(firstName, lastName, year);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName=" + getFirstName() +
                "lastName=" + getLastName() +
                "rating=" + rating +
                '}';
    }
}