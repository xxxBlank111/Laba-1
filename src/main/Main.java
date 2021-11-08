package main;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Выберите действие\n"+
                "1-добавить дом\n"+
                "2-добавить квартиру\n"+
                "3-удалить дом\n"+
                "4-удалить квартиру\n"+
                "5-сравнить дома\n"+
                "6-сравнить квартиры\n"+
                "7-информация о доме\n"+
                "8-информация о квартире\n"+
                "0-выйти из программы\n");

            boolean closingtheprogram = true;
            AccountingSystem accountingSystem = new AccountingSystem();
            Scanner num = new Scanner(System.in);
        while (closingtheprogram)
            {
                System.out.print("Введите число");
                int choice = 0;
                choice = num.nextInt();
                System.out.println(" ");

                if (choice == 0) {
                    closingtheprogram = false;
                }
                else if (choice == 1) {
                    System.out.println("введите номер дома");
                    int number = num.nextInt();
                    accountingSystem.addHome(number);
                }
                else if (choice == 2) {
                    System.out.println("Введите номер дома, в который хотите добавить квартиру");
                    int number = num.nextInt();
                    accountingSystem.addApartment(number);
                }
                else if (choice == 3) {
                    System.out.println("Введите номер дома");
                    accountingSystem.removeHome(num.nextInt());
                }
                else if (choice == 4) {
                    System.out.println("Введите номер дома и квартиры");
                    accountingSystem.removeApartment(num.nextInt(),num.nextInt());
                }
                else if (choice == 5) {
                    System.out.println("Введите номер дома");
                    int numberOfHomeOne = num.nextInt();
                    System.out.println("Введите номер дома");
                    int numberOfHomeTwo = num.nextInt();
                    accountingSystem.compareHome(numberOfHomeOne,numberOfHomeTwo);
                }
                else if (choice == 6) {
                    System.out.println("Введите номер дома и квартиры");
                    int numberOfHome1 = num.nextInt();
                    int numberOfApartment1 = num.nextInt();
                    System.out.println("Введите номер дома и квартиры");
                    int numberOfHome2 = num.nextInt();
                    int numberOfApartment2 = num.nextInt();
                    accountingSystem.compareApartment(numberOfHome1,numberOfHome2,numberOfApartment1,numberOfApartment2);
                }
                else if (choice == 7) {
                    System.out.println("Введите номер дома");
                    accountingSystem.getHomeInformation(num.nextInt());
                }
                else if (choice == 8) {
                    System.out.println("Введите номер дома и квартиры");
                    accountingSystem.getApartmentInformation(num.nextInt(), num.nextInt());
                }
                else
                {
                    System.out.println("Выбрано неверное действие");
                }

            }System.out.println("Завершение программы");
        }
    }
