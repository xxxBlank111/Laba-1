package main;

import java.util.ArrayList;
import java.util.List;
import computation.Comput;
import interfaces.Info;
public class House {
    private int number_house;//номер
    private int flatCount;//количество квартир
    private int floorCount;
    private List<Flat> flat = new ArrayList<Flat>();

    public House(int number_house,int flatCount,int floorCount, List<Flat> flat) {
        this.number_house = number_house;
        this.flatCount = flatCount;
        this.floorCount = floorCount;
        this.flat = flat;
    }
    public Flat getFlat( int number){
        for (Flat i : flat) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat("empty");
        temp.setNumber(-1);
        return temp;
    }
    public static int countSquare (House home){
        int result = 0;
        for (Flat i : home.getFlat()) {
            result += i.getSquare();
        }
        return result;
    }

    public void printInfo1 () {
        Info.printInfo_house(number_house,flatCount, floorCount);
    }

    public void compareBy (House home){
        String sign = new String("");
        this.floorCount = Comput.FloorCount(this.flatCount);
        home.floorCount = Comput.FloorCount(home.flatCount);

        System.out.println("Количество квартир");
        System.out.println("   Дом " + this.number_house + " Дом " + home.number_house);
        sign = Comput.getSign(this.flatCount, home.flatCount);
        System.out.println("     " + sign);

        System.out.println("Количество этажей");
        System.out.println("   Дом " + this.number_house + " Дом " + home.number_house);
        sign =Comput.getSign(this.floorCount,home.floorCount);
        System.out.println("     " + sign);

        System.out.println("Общая площадь");
        System.out.println("   Дом " + this.number_house + " Дом " + home.number_house);
        sign = Comput.getSign(this.number_house,home.number_house);
        System.out.println("     " + sign);

        System.out.println("Количество жильцов");
        System.out.println("   Дом " + this.number_house + " Дом " + home.number_house);
        sign = Comput.getSign(this.number_house,home.number_house);
        System.out.println("     " + sign);
    }
    public int getNumber () {return number_house;}
    public int getFlatCount () {return flatCount;}
    public int getFloorCount () {return floorCount;}
    public List<Flat> getFlat () {return flat;}
    public void setApartmentCount ( int apartmentCount){this.flatCount = apartmentCount;}
    public void setFloorCount ( int floorCount){this.floorCount = floorCount;}
    public void setApartments (ArrayList < Flat > flat) {this.flat = flat;}
    public void removeFlat (Flat temp){flat.remove(temp);}
    public void addFlat (Flat newFlat){flat.add(newFlat);}
}