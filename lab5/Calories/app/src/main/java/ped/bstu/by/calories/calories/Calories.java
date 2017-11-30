package ped.bstu.by.calories.calories;

import android.util.Log;

public class Calories {
    static double arm;
    static double bmr;
    static double calories;

    public static double caclCalories(String sex, int weight, int height, int age, String activityLevel) {
        Log.d("Log_02", "Пол: " + sex);
        Log.d("Log_02", "Вес: " + weight);
        Log.d("Log_02", "Рост: " + height);
        Log.d("Log_02", "Возраст: " + age);
        Log.d("Log_02", "Активность: " + activityLevel);
        if(sex.equals("Мужской")) {
            bmr = 66.5 + ( 13.75 * weight) + (5.003 * height - (6.755 * age));
        } else if(sex.equals("Женский")) {
            bmr = 655 + ( 9.563 * weight) + ( 1.850 * height) - (4.676 * age);
        }

        Log.d("Log_02", "Bmr: " + bmr);

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

        return Math.round(calories);
    }

}
