package builders;

import main.Flat;
import main.House;
import main.AccountingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseBuilder {
    {
        private int number_house;
        private int flatCount;
        private int floorCount;
        private List<Flat> flat = new ArrayList<Flat>();
    }
    public int qualityInput() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Введите целое положительное число");
        }
        int i = input.nextInt();
        return i;
    }
    public boolean checkApartmentCount(int i) {
        if (i % floorCount != 0) {
            System.out.println("Количество квартир должно быть кратно количеству этажей!\n"
                    + "Повторите ввод");
            return false;
        }
        return true;
    }
    public boolean checkHomeNumber(int numberOfHome) {
        AccountingSystem accountingSystem = new AccountingSystem();
        List<House> homes = accountingSystem.getHouse();
        for (House i : homes) {
            if (i.getNumber() == numberOfHome) {
                System.out.println("Дом с таким номером уже есть!");
                return false;
            }
        }
        return true;
    }
    public void fixNumber() {
        System.out.println("Введите номер дома");
        this.number_house = qualityInput();
        if (!checkHomeNumber(this.number_house)) {
            fixNumber();
        }
    }
    public void fixApartmentCount() {
        System.out.println("Введите количество квартир");
        this.flatCount = qualityInput();
        while (!checkApartmentCount(this.flatCount)) {
            this.flatCount = qualityInput();
        }
    }
    public void fixFloorCount() {
        System.out.println("Введите количество этажей");
        this.floorCount = qualityInput();
    }
    public void fixApartments() {
        int cntApartmentForFloor = this.flatCount / this.floorCount;
        int tempFloor = 1;
        for (int i = 1; i <= flatCount; i++) {
            FlatBuilder apartmentBuilder = new FlatBuilder(i, tempFloor);
            if (i % cntApartmentForFloor == 0) {
                tempFloor++;
            }
            this.flat.add(FlatBuilder.builders());
        }
    }
    public House builders () {
        fixNumber();
        fixFloorCount();
        fixApartmentCount();
        fixApartments();
        return new House(number_house,flatCount,floorCount,flat);
    }
}
