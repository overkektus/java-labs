package ped.bstu.by.calories.calories;

public class Calories {
    static double arm;
    static double bmr;
    static double calories;

    public static double caclCalories(String sex, int weight, int height, int age, String activityLevel) {
        if(sex == "мужской") {
            bmr = 66.5 + ( 13.75 * weight) + (5.003 * height - (6.755 * age));
        } else if(sex == "женский") {
            bmr = 655 + ( 9.563 * weight) + ( 1.850 * height) - (4.676 * age);
        }

        switch (activityLevel) {
            case "Низкая":
                calories = bmr * 1.2;
                break;
            case "Невысокая":
                calories = bmr * 1.375;
                break;
            case "Умеренная":
                calories = bmr * 1.55;
                break;
            case "Высокая":
                calories = bmr * 1.725;
                break;
            case "Экстремальная":
                calories = bmr * 1.9;
                break;
            default: calories = bmr * 1.55;
        }

        return calories;
    }

}
