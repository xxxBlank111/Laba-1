package builders;

import computation.Comput;
import object.Flat;

import java.util.Scanner;

public class FlatBuilder {
    private int square;
    private int roomer;
    private int humans;
    private int number;
    private int floor;

    public FlatBuilder(int square,int floor,int humans,int roomer,int number) {
        setSquare(square);
        setFloor(floor);
        setHumans(humans);
        setRoomer(roomer);
        setNumber(number);
    }

    public FlatBuilder(int iterator, int tempFloor) {
        this.number = iterator;
        this.floor = tempFloor;
    }

    public FlatBuilder build() {
        this.square=square;
        this.floor=floor;
        this.humans=humans;
        this.roomer=roomer;
        this.number=number;
        return new FlatBuilder(square, roomer, humans, number, floor);
    }
    public FlatBuilder() {
    }

    public void setSquare(int square) {
        this.square = positiveTest(square);
    }
    public int getSquare(){return square;}

    public void setNumber(int number) {this.number =positiveTest(number) ;}
    public int getNumber(){return number;}

    public void setRoomer(int roomer) {this.roomer = positiveTest(roomer);}
    public int  getRoomer(){return roomer;}

    public void setHumans(int humans ) {this.humans = positiveTest(humans);}
    public int getHumans() {return humans;}

    public void setFloor(int floor) {this.floor=positiveTest(floor);}
    public int getFloor(){return floor;}

    public int positiveTest(int verifiable) {
        if (verifiable >= 0) {
            return verifiable;
        } else {
            return 1;
        }
    }
}