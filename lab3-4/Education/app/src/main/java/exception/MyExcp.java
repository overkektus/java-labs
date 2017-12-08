package exception;

/**
 * Created by Egor on 17.10.2017.
 */

public class MyExcp extends Exception {
    private int number;
    public int getNumber(){
        return number;
    }
    public MyExcp(String message, int num){
        super(message);
        number = num;
    }
}
