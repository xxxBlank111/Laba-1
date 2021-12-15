package computation;
import builders.FlatBuilder;
import builders.HouseBuilder;
import object.House;
import java.util.ArrayList;
import java.util.List;
public class AccountingSystem {

    private static List<HouseBuilder> houses = new ArrayList<HouseBuilder>();

    public HouseBuilder findHouseByNumber(int number) {
        for (HouseBuilder i : houses) {
            if (i.getNumber() == number) {
                return i;
            }
        }
        HouseBuilder temp = new HouseBuilder();
        temp.setFlatCount(-1);
        return temp;
    }

    public String addHouse(int number, int flatCount, int floorCount) {

        HouseBuilder house = new HouseBuilder(number, flatCount, floorCount);
        int cntFlatForFloor = house.getFlatCount() / house.getFloorCount();
        int tempFloor = 1;
        for (int iterator = 1; iterator <= flatCount; iterator++) {
            FlatBuilder flatBuilder = new FlatBuilder(iterator,tempFloor);
            houses.getFlat().add(flatBuilder.build());
            if (iterator % cntFlatForFloor == 0) {
                tempFloor++;
            }
        }
        houses.add(house);
        return  "Дом успешно добавлен" ;
    }


    public String removeHouse(int number) {
        HouseBuilder temp = findHomeByNumber(number);
        houses.remove(temp);
        return "Дом успешно удален";
    }

    public static List<HouseBuilder> getHouse() {
        return houses;
    }
}