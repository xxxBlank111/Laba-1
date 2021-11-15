package builders;

import computation.Comput;
import main.Flat;

import java.util.Scanner;

public class FlatBuilder {
    private int square;
    private int roomer;
    private int number;
    private int floor;

    public FlatBuilder(int number, int floor) {
        Scanner num = new Scanner(System.in);
        this.number = number;
        this.floor = Comput.FloorCountFlat(num.nextInt());
    }

    public void fixSquare() {
        Scanner date = new Scanner(System.in);
        this.square = date.nextInt();
    }

    public void fixRoomer() {
        Scanner date = new Scanner(System.in);
        this.roomer = date.nextInt();
    }

    public Flat builder() {
        fixSquare();
        fixRoomer();
        return new Flat(square, roomer, number, floor);
    }
}