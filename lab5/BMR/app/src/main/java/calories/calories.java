package calories;

import java.util.ResourceBundle;

import ped.bstu.by.bmr.R;

/**
 * Created by Egor on 03.10.2017.
 */

public class calories {

    public static double caclCalories(String sex, int weight, int height, int age, String activityLevel) {
        double calories = 0;
        double bmr;
        double amr;

        amr = getArm(activityLevel);

        if(sex == "женский") {
            if (age > 20 ) {
                bmr = 655.0955 + (9.5634 * weight) + (1.8496 * height) - (4.6756 * age);
                calories = bmr * amr;
            } else {
                bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
                calories = bmr * amr;
            }
        } else {
            if (age > 20) {
                bmr = 66.4730 + (13.7516 * weight) + (5.0033 * age) - (6.7550 * age);
                calories = bmr * amr;
            } else {
                bmr = 88.362  + (13.397 * weight) + (4.799 * age) - (5.677 * age);
                calories = bmr * amr;
            }
        }

        return calories;
    }

    private static double getArm(String activityLevel) {
        double amr;

        switch (activityLevel) {
            case "Сидячий образ жизни": amr = 1.2;
                break;
            case "Умеренная активность": amr = 1.375;
                break;
            case "Средняя активность": amr = 1.55;
                break;
            case "Активные люди": amr = 1.725;
                break;
            case "Спортсмены": amr = 1.9;
                break;
            default: amr = 1.5;
        }
        return amr;
    }

}
