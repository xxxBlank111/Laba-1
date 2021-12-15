package interfaces;
import computation.AccountingSystem;
import object.Flat;
import object.House;

import java.util.Map;
import java.util.Scanner;

import validate.Validate;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class UsersInterface {

    private static final String USER_MENU = """
               
               1 - добавить дом
               2 - удалить дом
               3 - сравнить дома
               4 - сравнить квартиры
               5 - получить информацию о доме
               6 - получить информацию о квартире
               7 - получить информацию о всех квартирах дома
               0 - выйти из программы
            """;

    public int listenQuery() {

        Scanner input = new Scanner(System.in);
        int query = input.nextInt();
        while (query < 0 || query > 7) {
            System.out.println( "Введите число от 1 до 8" );
            query = input.nextInt();
        }

        return query;
    }

    public void showMenu() {
        System.out.println(USER_MENU);
    }

    public void printFlatInformation(Map<String,Integer> apartmentInformation) {
        System.out.printf("""
                            Информация о квартире № %d:
                            Площадь            : %d
                            Количество жильцов : %d
                            Количество комнат  : %d
                            Этаж               : %d
                            """,apartmentInformation.get("number"), apartmentInformation.get("sqare"),
                apartmentInformation.get("roomer"),apartmentInformation.get("cntRooms"),apartmentInformation.get("floor"));
    }

    public void handleQuery() {

        String messange;
        int query = 1;
        int numberOfHouse,numberOfFlat;
        AccountingSystem accountingSystem = new AccountingSystem();
        Scanner input = new Scanner(System.in);
        showMenu();

        while (query > 0) {
            System.out.println("Выберите действие");
            query = listenQuery();
            switch (query) {

                case 1 -> {

                    System.out.println("""
                            Введите номер дома, количество квартир и количество этажей
                            (Количество квартир должно быть кратно количеству этажей)
                            """);
                    numberOfHouse = input.nextInt();
                    int floorCount = input.nextInt();
                    int apartmentCount = input.nextInt();

                    Validate.checkAvailabilityOfHouse(numberOfHouse);
                    Validate.checkQualityApartmentCount(floorCount,apartmentCount);

                    System.out.println(accountingSystem.addHouse(numberOfHouse,apartmentCount,floorCount));

                }
                case 2 -> {

                    System.out.println("Введите номер дома");
                    numberOfHouse = input.nextInt();

                    Validate.checkNumberOfHome(numberOfHouse);
                    messange = accountingSystem.removeHouse(numberOfHouse);
                    System.out.println(messange);

                }
                case 3 -> {

                    System.out.println("Введите номер первого дома");
                    numberOfHouse = input.nextInt();
                    Validate.checkNumberOfHome(numberOfHouse);

                    System.out.println("Введите номер второго дома");
                    int numberOfHouseTwo = input.nextInt();
                    Validate.checkNumberOfHome(numberOfHouse);

                    Map<String,Character> signs = House.compareHouse(accountingSystem.findHouseByNumber(numberOfHouse),
                            accountingSystem.findHouseByNumber(numberOfHouseTwo));
                    System.out.printf("""
                                    Сравнение домов       №%d  и  №%d
                                    Количество квартир  :     %c
                                    Количество этажей   :     %c
                                    Общая жилая площадь :     %c
                                    """,
                            numberOfHouse,
                            numberOfHouseTwo,
                            signs.get("apartmentCount"),
                            signs.get("floorsCount"),
                            signs.get("sqare"));

                }
                case 4 -> {

                    System.out.println("Введите данные для двух квартир(номер дома и квартиры)");

                    System.out.println("Для первой :");
                    numberOfHouse = input.nextInt();
                    numberOfFlat = input.nextInt();
                    Validate.checkNumberOfHome(numberOfHouse);
                    Validate.checkNumberOfApartment(numberOfHouse,numberOfFlat);
                    House houseService = new House(accountingSystem.findHouseByNumber(numberOfHouse));

                    System.out.println("Для второй :");
                    int numberOfHouseTwo = input.nextInt();
                    int numberOfApartmentTwo = input.nextInt();
                    Validate.checkNumberOfHome(numberOfHouseTwo);
                    Validate.checkNumberOfApartment(numberOfHouseTwo,numberOfApartmentTwo);
                    House houseServiceTwo = new House(accountingSystem.findHouseByNumber(numberOfHouseTwo));

                    Map<String,Character> signs = Flat.compareFlat(houseService.getFlat(numberOfFlat),
                            houseServiceTwo.getFlat(numberOfApartmentTwo));

                    System.out.printf("""
                            Сравнение квартир    Дом №%d,кв. №%d и Дом №%d,кв. №%d
                            Площадь            :                %c
                            Количество жильцов :                %c
                            Количество комнат  :                %c
                            Этаж               :                %c
                            """,
                            numberOfHouse,
                            numberOfFlat,
                            numberOfHouseTwo,
                            numberOfApartmentTwo,
                            signs.get("sqare"),
                            signs.get("roomers"),
                            signs.get("cntRooms"),
                            signs.get("floor"));


                }
                case 5 -> {

                    System.out.println("Введите номер дома");
                    numberOfHouse = input.nextInt();
                    Validate.checkNumberOfHome(numberOfHouse);
                    House houseService = new House(accountingSystem.findHouseByNumber(numberOfHouse));
                    Map<String,Integer> result = houseService.getInfo();
                    System.out.printf("""
                            Информация о доме №%d
                            Количество квартир : %d
                            Количество этажей  : %d
                            """,
                            result.get("number"),
                            result.get("apartmentCount"),
                            result.get("floorsCount"));

                }
                case 6 -> {

                    System.out.println("Введите номер дома и квартиры");
                    numberOfHouse = input.nextInt();;
                    numberOfFlat = input.nextInt();
                    Validate.checkNumberOfHome(numberOfHouse);
                    Validate.checkNumberOfApartment(numberOfHouse,numberOfFlat);

                    House house = AccountingSystem.findHouseByNumber(numberOfHouse);
                    House houseService = new House(house);
                    Flat fService = new Flat(houseService.getFlat(numberOfFlat));

                    Map<String,Integer> apartmentInformation = fService.getInfo();
                    printFlatInformation(apartmentInformation);

                }
                case 7 -> {
                    System.out.println("Введите номер дома");
                    numberOfHouse = input.nextInt();
                    Validate.checkNumberOfHome(numberOfHouse);
                    House house = accountingSystem.findHouseByNumber(numberOfHouse);

                    Map<String,Integer> apartmentInformation = new HashMap<>();
                    for(Flat i : house.getFlat()) {
                        Flat apartmentService = new Flat();
                        apartmentInformation = apartmentService.getInfo();
                        printFlatInformation(apartmentInformation);
                    }
                }

            }
        }

    }
}