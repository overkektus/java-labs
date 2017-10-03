package com.example.egor.lab2.by.bstu.piskunou.basejava;

import static java.lang.Math.*;

/**
 * Created by Egor on 26.09.2017.
 */

public class JavaTestType {
    /*
    * @author Egor
    * @version 1.0
    * */
    /*c)*/
    final int fi = 10;
    public final int pfi = 20;
    public static final int psfi = 30;
    /*-----------------------------------------------------------------------------------------------*/

    public static void main() {
        /*
        * @return 0
        * @throws
        * @param
        * */

        /*b)*/
        System.out.println("b)");

        char ch = 'd';
        int i = 7474;
        short s = 9;
        byte b = 1;
        long l = 426427;
        boolean bool = true;
        String str = "str";

        System.out.println("String + int = " + str + i);
        System.out.println("String + char = " + str + ch);
        System.out.println("String + double = " + str + ch);
        System.out.println("byte + int = byte" + str + ch);
        System.out.println("double + long = int" + str + ch);
        System.out.println("2147483647 + int = long" + str + ch);
        System.out.println("static int sint " + str + ch); //значение без инициализации
        boolean b1 = true && false;
        System.out.println("boolean && boolean = " + b1);
        boolean b2 = false ^ true;
        System.out.println("boolean ^ boolean = " + b2);
        System.out.println("boolean + boolean - нельзя");
        long num1 = 9223372036854775807L;
        System.out.println("Тип для числа " + num1 + " - long");
        long num2 = 0x7fff_ffff_fffL;
        System.out.println("Тип для числа " + num2 + " - long");
        char c = 'M';
        System.out.println("Char " + c + "(" + (int) c + ")" + " - " + "a" + " = " + (c - 'a'));
        System.out.println("Char " + c + "(" + (int) c + ")" + " - " + "\\u0061" + " = " + (c - '\u0061'));
        //System.out.println("Char " + c + "(" + (int)c + ")" + " - " + "a" + " = " + (c - 'a'));

        System.out.println("3.45 % 2.4 = " + 3.45 % 2.4);
        System.out.println("1.0/0.0 = " + 1.0 / 0.0);
        System.out.println("0.0/0.0 = " + 0.0 / 0.0);
        System.out.println("log(-345) = " + Math.log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000)" + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000)" + Float.intBitsToFloat(0xFF800000));
        /*-----------------------------------------------------------------------------------------------*/

        /*d)*/
        System.out.println("d)");

        System.out.println("Math.PI = " + PI);
        System.out.println("Math.E = " + E);
        System.out.println("Math.round(Math.PI) = " + round(PI));
        System.out.println("Math.round(Math.E) = " + round(E));
        System.out.println("Math.min()" + min(round(PI), round(E)));
        System.out.println("случайное число из диапазона [0,1): " + random() * 1);
        /*-----------------------------------------------------------------------------------------------*/

        /*e)*/
        //TODO: operation >>>, >>, ~, &, *, -, +
        //TODO: методы для Integer
        System.out.println("e)");

        Boolean booleanWrapped = new Boolean(true);
        Character characterWrapped = new Character('g');
        Integer integerWrapped = new Integer(1398562960);
        Byte byteWrapped = new Byte((byte) 20);
        Short shortWrapped = new Short((short) 16526);
        Long longWrapped = new Long(353622097208L);
        Double doubleWrapped = new Double(325.523);

        System.out.println("Long: " + "MIN_VALUE = " + Long.MIN_VALUE + "; MAX_VALUE" + Long.MAX_VALUE);
        System.out.println("Double: " + "MIN_VALUE = " + Double.MIN_VALUE + "; MAX_VALUE" + Double.MAX_VALUE);

        //автоупаковка
        Integer aint = 1350;
        Byte abyte = 110;

        //распаковка
        int rint = aint;
        byte rbyte = abyte;

        int p = Integer.parseInt("gd45");

        System.out.println(p);
        /*-----------------------------------------------------------------------------------------------*/

        /*f)*/
        System.out.println("f)");

        String s34 = "2345";
        Integer ints34 = Integer.valueOf(s34);
        System.out.println("Integer.valueOf(): " + ints34);

        int int2s32 = Integer.parseInt(s34);
        System.out.println("Integer.parseInt(): " + int2s32);

        byte[] bytes34 = s34.getBytes();
        System.out.println("Последовательность байт строки: " + bytes34);

        //TODO: byte to string
        System.out.printf("Обратное преобразование из байт: ");

        boolean match = s34.matches("(.*)(\\d+)(.*)");
        System.out.println("Преобразование в bool с помощью matches(): " + match);

        boolean endsWith = s34.endsWith("3");
        System.out.println("Преобразование в bool с помощью endsWith(): " + endsWith);

        /*-----------------------------------------------------------------------------------------------*/

        /*g)*/
        System.out.println("g)");

        char[][] c1;
        char[] c2[];
        char c3[][];

        /*-----------------------------------------------------------------------------------------------*/

        /*h)*/
        System.out.println("h)");

        WrapperString ws = new WrapperString();


        /*-----------------------------------------------------------------------------------------------*/
    }
}
