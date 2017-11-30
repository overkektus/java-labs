package ped.bstu.by.calories.FieldsValidation;

/**
 * Created by Egor on 29.10.2017.
 */

public interface Validator<T> {

    boolean isValid(T value);

    String getDescription();
}
