package main;
import java.util.*;

public class AccountingSystem {
    private ArrayList<House> homes = new ArrayList<House>();

    public House findHomeByNumber(int number) {
        for (House i : homes) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        House temp = new House("empty");
        temp.setApartmentCount(-1);
        return temp;
    }
    public Flat findApartmentByNumber(House home, int number) {
        for (Flat i : home.getApartments()) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat("empty");
        temp.setNumber(-1);
        return temp;
    }

    public void addHome(int number) {
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

    public void addApartment(int numberOfHome) {
        House temp = findHomeByNumber(numberOfHome);
        if (temp.getApartmentCount() == -1) {
            System.out.println("Дома с таким номером не существует");
            return;
        } else {
            Flat tempApartment = new Flat();
            temp.addApartment(tempApartment);
            System.out.println("Квартира успешно добавлена");
        }
    }
    public void getApartmentInformation(int numberOfHome, int numberOfApartment) {
        House temp = findHomeByNumber(numberOfHome);
        if (temp.getApartmentCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        Flat temp2 = temp.getApartment(numberOfApartment);
        if (temp.getNumber() == -1) {
            System.out.println("Такой квартиры не существует");
            return;
        }
        temp2.printInfo();
    }
    public void getHomeInformation(int number) {
        House temp = findHomeByNumber(number);
        if (temp.getApartmentCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        for (Flat i : temp.getApartments()) {
            i.printInfo();
        }
        if (temp.getApartments().size() == 0) {
            System.out.println("В доме нет квартир");
        }

    }
    public void removeHome(int number) {
        House temp = findHomeByNumber(number);
        if (temp.getApartmentCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        homes.remove(temp);
    }

    public void removeApartment(int numberOfHome, int numberOfApartment) {
        House temp = findHomeByNumber(numberOfHome);
        if (temp.getApartmentCount() == -1) {
            System.out.println("Такого дома нет");
            return;
        }
        Flat temp1 = findApartmentByNumber(temp, numberOfApartment);
        if (temp1.getNumber() == -1) {
            System.out.println("Такой квартиры нет");
            return;
        }
        temp.removeApartment(temp1);
    }
    public void compareApartment(int numberOfHome1, int numberOfHome2, int numberOfApartment1, int numberOfApartment2) {

        House home1 = findHomeByNumber(numberOfHome1);
        if (home1.getApartmentCount() == -1) {
            System.out.println("1 квартиры нет");
            return;
        }
        Flat apartment1 = findApartmentByNumber(home1, numberOfApartment1);
        if (apartment1.getNumber() == -1) {
            System.out.println("1 квартиры нет");
            return;
        }
        House home2 = findHomeByNumber(numberOfHome2);
        if (home2.getApartmentCount() == -1) {
            System.out.println("2 квартиры нет");
            return;
        }
        Flat apartment2 = findApartmentByNumber(home2, numberOfApartment2);
        if (apartment2.getNumber() == -1) {
            System.out.println("2 квартиры нет");
            return;
        }
        apartment1.compareBy(apartment2);
    }
    public void compareHome(int numberOfHomeOne, int numberOfHomeTwo) {
        House homeOne = findHomeByNumber(numberOfHomeOne);
        if (homeOne.getApartmentCount() == -1) {
            System.out.println("1 Дома не существует");
            return;
        }
        House homeTwo = findHomeByNumber(numberOfHomeTwo);
        if (homeTwo.getApartmentCount() == -1) {
            System.out.println("2 Дома не существует");
            return;
        }
        homeOne.compareBy(homeTwo);
    }
}