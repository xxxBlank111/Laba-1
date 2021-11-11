package main;
import java.util.*;
import java.util.Scanner;
import computation.Comput;
import interfaces.Info;
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
    public void printCompareResult(String sign, int apartmentNumber) {
        System.out.println("квартира" + this.number + sign + "квартира" + apartmentNumber);
    }
    public void compareBy(Flat apartment) {

        String sign = new String("");

        System.out.println("Площадь :");
        sign = Comput.getSign(this.square, apartment.square);
        printCompareResult(sign, apartment.number);

        System.out.println("Количество жильцов");
        sign = Comput.getSign(this.roomer, apartment.roomer);
        printCompareResult(sign, apartment.number);

        System.out.println("Номер квартиры");
        sign = Comput.getSign(this.number, apartment.number);
        printCompareResult(sign, apartment.number);

        System.out.println("Этаж");
        sign = Comput.getSign(this.floor, apartment.floor);
        printCompareResult(sign, apartment.number);

    }
    public void printInfo1 () {
        Info.printInfo_flat(number, square, roomer, floor);
    }

    public int getSquare() {
        return square;
    }
    public int getNumber() {return number;}
    public int getFloor() {return floor;}
    public int getRoomer() {
        return roomer;
    }
    public void setRoomer(int roomer) {
        this.roomer = roomer;
    }
    public void setSquare(int square) {
        this.square = Comput.FloorCount(square);
    }
    public void setNumber(int number) {
        this.number = number;
    }
}