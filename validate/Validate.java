package validate;
import computation.AccountingSystem;
import builders.FlatBuilder;
import builders.HouseBuilder;
import java.util.Optional;

public class Validate { public static void checkNumberOfHome(int numberOfHouse) {
    Optional<HouseBuilder> house = AccountingSystem.getHouse()
            .parallelStream()
            .filter(e -> e.getNumber() == numberOfHouse)
            .findFirst();
    if (house.isEmpty()) {
        throw new IllegalArgumentException("Дома с номером " + numberOfHouse + " нет");
    }
}

    public static void checkAvailabilityOfHouse(int numberOfHouse) {
        Optional<HouseBuilder> house = AccountingSystem.getHouse()
                .parallelStream()
                .filter(e -> e.getNumber() == numberOfHouse)
                .findFirst();
        if (house.isPresent()) {
            throw new IllegalArgumentException("Дома с номером " + numberOfHouse + " уже есть");
        }

    }
    public static void checkNumberOfApartment(int numberOfHome, int numberOfApartment) {
        Optional<HouseBuilder> house = AccountingSystem.getHouse()
                .parallelStream()
                .filter(e -> e.getNumber() == numberOfHome)
                .findFirst();
        if (house.isEmpty()) {
            throw new IllegalArgumentException("Дома с номером " + numberOfHome + " нет");
        }

    }
    public static void checkQualityApartmentCount(int floorCount, int apartmentCount) {
        if (apartmentCount % floorCount != 0) {
            throw new IllegalArgumentException("Количество квартир должно быть кратно количеству этажей!");
        }
    }

}
