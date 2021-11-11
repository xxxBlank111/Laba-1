package interfaces;

public class Info {
        public static void printInfo_flat ( int number, int square, int roomer, int floor){
        System.out.println("Информация о квартире:");
        System.out.println("номер              - " + number);
        System.out.println("площадь            - " + square);
        System.out.println("количество жильцов - " + roomer);
        System.out.println("этаж               - " + floor);
    }
        public static void printInfo_house (int number_house, int apartmentCount, int floorCount) {
            System.out.println("Информация о доме :");
            System.out.println("Номер дома -" + number_house);
            System.out.println("Количество квартир - " + apartmentCount);
            System.out.println("Количество этажей - " + floorCount);
            System.out.println("Количество жильцов - ");
        }

}
