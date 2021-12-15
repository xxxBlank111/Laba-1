package object;

import builders.HouseBuilder;
import builders.FlatBuilder;
import computation.Comput;
import java.util.*;;

public class House {
    private HouseBuilder house;

    public House() {}
    public House(HouseBuilder house) {
        this.house = house;
    }

    public FlatBuilder getFlat(int number) {
        for (FlatBuilder i : house.getFlat()) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        Flat temp = new Flat();
        temp.setNumber(-1);
        return temp;
    }

    public Map<String,Integer> getInfo() {
        return Map.of("number", house.getNumber(),
                "apartmentCount", house.getFlatCount(),
                "floorsCount", house.getFloorCount());

    }

    public static int countSquare(House house) {
        int result = 0;
        for (FlatBuilder i : house.getFlat()) {
            result += i.getSquare();
        }
        return result;
    }

    public static Character getSign(int x, int y) {
        switch (Integer.compare(x, y)) {
            case 1 -> {
                return '>';
            }
            case 0 -> {
                return '=';
            }
            case -1 -> {
                return '<';
            }
        }
        return ' ';
    }

    public static Map<String,Character> compareHouse(House houseOne, House houseTwo) {
        Map<String,Character> result = new HashMap<>();
        result.put("apartmentCount",getSign(houseOne.getFlatCount(),houseTwo.getFlatCount()));
        result.put("floorsCount",getSign(houseOne.getFloorCount(),houseTwo.getFloorCount()));
        result.put("sqare",getSign(countSquare(houseOne),countSquare(houseTwo)));
        return Collections.unmodifiableMap(result);
    }

    public Collection<Object> getFlat() {
        return Collections.singleton(1);
    }
    }