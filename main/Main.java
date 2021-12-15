package main;
import interfaces.UsersInterface;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersInterface userInterface = new UsersInterface();
        userInterface.Query();
    }
}