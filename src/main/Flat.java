package main;
import java.util.*;
import java.util.Scanner;
public class Flat extends House{
    private int square;  // площадь
    private int roomer; // количество комнат
    private int number; // номер квартиры
    private int floor; // этаж

    public Flat() {
        Scanner num = new Scanner(System.in);
        System.out.println("введите площадь, количество комнат, номер квартиры,этаж и количество людей\n");
        this.square = num.nextInt();
        this.roomer = num.nextInt();
        this.number = num.nextInt();
        this.floor = num.nextInt();
    }
    Flat(String empty) {
    }
    public String getSign(int x, int y) {

        switch (Integer.compare(x, y)) {
            case 1 -> {
                return x+" > "+y;
            }
            case 0 -> {
                return x+" = "+y;
            }
            case -1 -> {
                return x+" < "+y;
            }
        }
        return "";
    }
    public void printCompareResult(String sign, int apartmentNumber) {
        System.out.println("квартира" + this.number + sign + "квартира" + apartmentNumber);
    }

    public void compareBy(Flat apartment) {

        String sign = new String("");

        System.out.println("Площадь :");
        sign = getSign(this.square, apartment.square);
        printCompareResult(sign, apartment.number);

        System.out.println("Количество жильцов");
        sign = getSign(this.roomer, apartment.roomer);
        printCompareResult(sign, apartment.number);

        System.out.println("Номер квартиры");
        sign = getSign(this.number, apartment.number);
        printCompareResult(sign, apartment.number);

        System.out.println("Этаж");
        sign = getSign(this.floor, apartment.floor);
        printCompareResult(sign, apartment.number);

    }
    public static int FloorCnt(int x) {
        int y = x;
        int i = 0;
        while (y >= 3) {
            if (i == 0)
                y -= 2;
            else
                y -= 3;
            i++;
        }
        return i + 1;
    }
    public void printInfo() {
        System.out.println("Информация о квартире:");
        System.out.println("номер              - " + this.getNumber());
        System.out.println("площадь            - " + this.getSquare());
        System.out.println("количество жильцов - " + this.getRoomer());
        System.out.println("этаж               - " + this.getFloor());
    }
    public int getSquare() {
        return square;
    }
    public void setSquare(int square) {
        this.square = FloorCnt(square);
    }
    public int getRoomer() {
        return roomer;
    }
    public void setRoomer(int roomer) {
        this.roomer = roomer;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getFloor() {
        return floor -1;// место под кухню
    }
}

