package main;
import java.util.*;

public class AccountingSystem {
    private ArrayList<House> homes = new ArrayList<House>();
    public House findHouseByNumber(int number) {
        for (House i : homes) {
            if (i.getNumber() == number)
            {
                return i;
            }
        }
        House temp = new House();
        temp.setFlatCount(-1);
        return temp;
    }
    public Flat findFlatByNumber(House home, int number) {
        for (Flat i : home.getFlat()) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat("empty");
        temp.setNumber(-1);
        return temp;
    }

    public void addHouse(int number) {
        for (House i : homes) {
            if (i.getNumber() == number) {
                System.out.println("Дом с таким номером существует");
                return;
            }
        }
        House home = new House(number);
        homes.add(home);
        System.out.println("Дом успешно добавлен");
    }
    public void addFlat(int numberOfHome) {
        House temp = findHouseByNumber(numberOfHome);
        if (temp.getFlatCount() == -1) {
            System.out.println("Дома с таким номером не существует");
            return;
        } else {
            Flat tempApartment = new Flat();
            temp.addFlat(tempApartment);
            System.out.println("Квартира успешно добавлена");
        }
    }
    public void getFlatInformation(int numberOfHome, int numberOfApartment) {
        House temp = findHouseByNumber(numberOfHome);
        if (temp.getFlatCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        Flat temp2 = temp.getFlat(numberOfApartment);
        if (temp.getNumber() == -1) {
            System.out.println("Такой квартиры не существует");
            return;
        }
        temp2.printInfo1();
    }
    public void getHouseInformation(int number) {
        House temp = findHouseByNumber(number);
        if (temp.getFlatCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        for (Flat i : temp.getFlat()) {
            i.printInfo1();
        }
        if (temp.getFlat().size() == 0) {
            System.out.println("В доме нет квартир");
        }

    }
    public void removeHouse(int number) {
        House temp = findHouseByNumber(number);
        if (temp.getFlatCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        homes.remove(temp);
    }

    public void removeFlat(int numberOfHome, int numberOfApartment) {
        House temp = findHouseByNumber(numberOfHome);
        if (temp.getFlatCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        Flat temp1 = findFlatByNumber(temp, numberOfApartment);
        if (temp1.getNumber() == -1) {
            System.out.println("Такой квартиры нет");
            return;
        }
        temp.removeFlat(temp1);
    }
    public void compareFlat(int numberOfHome1, int numberOfHome2, int numberOfApartment1, int numberOfApartment2) {

        House home1 = findHouseByNumber(numberOfHome1);
        if (home1.getFlatCount() == -1) {
            System.out.println("1 квартиры нет");
            return;
        }
        Flat apartment1 = findFlatByNumber(home1, numberOfApartment1);
        if (apartment1.getNumber() == -1) {
            System.out.println("1 квартиры нет");
            return;
        }
        House home2 = findHouseByNumber(numberOfHome2);
        if (home2.getFlatCount() == -1) {
            System.out.println("2 квартиры нет");
            return;
        }
        Flat apartment2 = findFlatByNumber(home2, numberOfApartment2);
        if (apartment2.getNumber() == -1) {
            System.out.println("2 квартиры нет");
            return;
        }
        apartment1.compareBy(apartment2);
    }
    public void compareHouse(int numberOfHomeOne, int numberOfHomeTwo) {
        House homeOne = findHouseByNumber(numberOfHomeOne);
        if (homeOne.getFlatCount() == -1) {
            System.out.println("1 Дома не существует");
            return;
        }
        House homeTwo = findHouseByNumber(numberOfHomeTwo);
        if (homeTwo.getFlatCount() == -1) {
            System.out.println("2 Дома не существует");
            return;
        }
        homeOne.compareBy(homeTwo);
    }
}