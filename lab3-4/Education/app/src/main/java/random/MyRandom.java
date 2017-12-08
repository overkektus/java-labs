package random;

import org.jetbrains.annotations.NotNull;
import organization.Organizations;
import units.Listener;
import units.Student;
import java.util.Random;

/**
 * Created by Egor on 17.10.2017.
 */

public class MyRandom {
    private static final Random random = new Random();
    static private String [] names =
            {
                "Олег", "Игорь", "Коля", "Максим",
                "Ваня", "Валя", "Дима", "Саша",
                "Егор", "Антон"
            };

    static private String [] surnames =
            {
                "Шуманский", "Рытиков", "Панасюк", "Горевой", "Стипаков",
                "Логвинов", "Куницкий", "Окулович", "Гуцев", "Гулько"
            };

    private MyRandom(){}

    @NotNull
    public static Listener randomListener() {
        return new Listener(randomName(), randomSurname(), randomAge(), randomOrg());
    }

    @NotNull
    public static Student randomStudent() {
        return new Student(randomName(), randomSurname(), randomAge(), randomRating());
    }

    private static int randomAge() {
        return (random.nextInt(29) + 1970);
    }

    private static String randomName() {
        return names[random.nextInt(names.length)];
    }

    private static String randomSurname() {
        return surnames[random.nextInt(surnames.length)];
    }

    private static double randomRating() {
        double rating = (Math.random() * 6) + 4;
        rating = Math.round(rating * 10.0) / 10.0;
        return rating;
    }

    private static Organizations randomOrg() {
        int size = Organizations.getVALUES().size();
        return Organizations.getVALUES().get(random.nextInt(size));
    }
}
