package main;
import java.util.Scanner;
import java.util.ArrayList;
import computation.Comput;
import interfaces.Info;

public class House {
    private int numberhouse;//номер
    private int apartmentCount;//количество квартир
    private int floorCount;
    private ArrayList<Flat> flat = new ArrayList<Flat>();

    public House() {
        System.out.println("Введите номер дома, количество квартир");
        Scanner num = new Scanner(System.in);
        this.numberhouse = num.nextInt();
        this.apartmentCount = num.nextInt();
        this.floorCount = num.nextInt();
    }

    //public House(String s)
    int [][] arr1= new int[14][14];
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
        for (Flat i : flat) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat("empty");
        temp.setNumber(-1);
        return temp;
    }
    public void printInfo1 () {
        Info.printInfo_house(numberhouse,apartmentCount, floorCount);
    }

    public static int countSquare (House home){
        int result = 0;
        for (Flat i : home.getApartments()) {
            result += i.getSquare();
        }
        return result;
    }
    public static int total_amount (int number_house, int [][] arr1)
    { int amount=0;
        for (int j = 0; j < 14; j++)
    {
        amount +=arr1[number_house][j];
    }
        return amount;
    }

    public void compareBy (House home){
        String sign = new String("");

        this.floorCount = Comput.FloorCount(this.apartmentCount);
        home.floorCount = Comput.FloorCount(home.apartmentCount);

        System.out.println("Количество квартир");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        sign = Comput.getSign(this.apartmentCount, home.apartmentCount);
        System.out.println("     " + sign);

        System.out.println("Количество этажей");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        sign =Comput.getSign(this.floorCount,home.floorCount);
        System.out.println("     " + sign);

        System.out.println("Общая площадь");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        total_amount(this.numberhouse,arr1);
        sign = Comput.getSign( total_amount(this.numberhouse,arr1), total_amount(this.numberhouse,arr2));
        System.out.println("     " + sign);

        System.out.println("Количество жильцов");
        System.out.println("   Дом " + this.numberhouse + " Дом " + home.numberhouse);
        sign = Comput.getSign( total_amount(this.numberhouse,arr1), total_amount(this.numberhouse,arr2));
        System.out.println("     " + sign);
    }
    public int getNumber () {return numberhouse;}
    public int getApartmentCount () {return apartmentCount;}
    public int getFloorCount () {return floorCount;}
    public ArrayList<Flat> getApartments () {return flat;}
    public void setApartmentCount ( int apartmentCount){this.apartmentCount = apartmentCount;}
    public void setFloorCount ( int floorCount){this.floorCount = floorCount;}
    public void setApartments (ArrayList < Flat > apartments) {this.flat = apartments;}
    public void removeApartment (Flat temp){flat.remove(temp);}
    public void addApartment (Flat newApartment){flat.add(newApartment);}
}