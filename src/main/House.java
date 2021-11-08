package main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class House {
    private int numberhouse;//номер
    private int apartmentCount;//количество квартир
    private int floorCount;
    private ArrayList<Flat> apartments = new ArrayList<Flat>();

    public House() {
        System.out.println("Введите номер дома, количество квартир");
        Scanner num = new Scanner(System.in);
        this.numberhouse = num.nextInt();
        this.apartmentCount = num.nextInt();
        this.floorCount = num.nextInt();

    }

    public House(String s) {
    }int [][] arr1= new int[14][14];
    int [][] arr2= new int[14][14];

    public House(int number) {
        System.out.println("Введите количество квартир");
        this.numberhouse = number;
        Scanner input = new Scanner(System.in);
            int c =input.nextInt();
            int i=number;
            for (int j = 0; j < c; j++)
            {
                System.out.println("Введите площадь "+(j+1)+" квартиры");
                Scanner num1 = new Scanner(System.in);
                arr1[i][j] = num1.nextInt();//площадь
                System.out.println("Введите жильцов "+(j+1)+" квартиры");
                Scanner num2 = new Scanner(System.in);
                arr2[i][j] = num2.nextInt();//люди
            }
        this.apartmentCount = input.nextInt();
        this.floorCount = input.nextInt();
    }
        public Flat getApartment ( int number){
        for (Flat i : apartments) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat("empty");
        temp.setNumber(-1);
        return temp;
    }
        public void printInfo () {
        System.out.println("Информация о доме :");
        System.out.println("Номер дома -" + this.numberhouse);
        System.out.println("Количество квартир - " + this.apartmentCount);
        System.out.println("Количество этажей - " + this.floorCount);
        System.out.println("Количество жильцов - ");
    }

        public static int countSquare (House home){
        int result = 0;
        for (Flat i : home.getApartments()) {
            result += i.getSquare();
        }
        return result;
    }
        public String getSign ( int x, int y){
        switch (Integer.compare(x, y)) {
            case 1 -> {
                return x + " > " + y;
            }
            case 0 -> {
                return x + " = " + y;
            }
            case -1 -> {
                return x + " < " + y;
            }
        }
        return "";
    }
        public static int FloorCnt ( int x){
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
        public void compareBy (House home){
        String sign = new String("");

        this.floorCount = FloorCnt(this.apartmentCount);
        home.floorCount = FloorCnt(home.apartmentCount);

        System.out.println("Количество квартир");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        sign = getSign(this.apartmentCount, home.apartmentCount);
        System.out.println("     " + sign);

        System.out.println("Количество этажей");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        sign = getSign(this.floorCount, home.floorCount);
        System.out.println("     " + sign);

        int squareOne=0;
        int squareTwo=0;
        int roomOne=0;
        int roomTwo=0 ;
        System.out.println("Общая площадь");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        int i1=this.numberhouse;
            for (int j = 0; j < 14; j++)
            {
                squareOne +=arr1[i1][j];
                roomOne+=arr2[i1][j] ;
            }
            int i2=home.numberhouse;
            for (int j = 0; j < 14; j++)
            {
                squareTwo  +=arr1[i2][j];
                roomTwo =arr2[i2][j];
            }
        sign = getSign(squareOne, squareTwo);
        System.out.println("     " + sign);

        System.out.println("Количество жильцов");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        sign = getSign(roomOne, roomTwo);
        System.out.println("     " + sign);

    }
        public void removeApartment (Flat temp){
        apartments.remove(temp);
    }
        public void addApartment (Flat newApartment){
        apartments.add(newApartment);
    }
        public int getNumber () {
        return numberhouse;
    }
        public int getApartmentCount () {
        return apartmentCount;
    }
        public void setApartmentCount ( int apartmentCount){
        this.apartmentCount = apartmentCount;
    }
        public int getFloorCount () {
        return floorCount;
    }
        public void setFloorCount ( int floorCount){
        this.floorCount = floorCount;
    }
        public ArrayList<Flat> getApartments () {
        return apartments;
    }
        public void setApartments (ArrayList < Flat > apartments) {
        this.apartments = apartments;
    }
    }
