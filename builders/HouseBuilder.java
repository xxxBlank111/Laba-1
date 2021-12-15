package builders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HouseBuilder {

    private int number;
    private int flatCount;
    private int floorCount;
    private List<FlatBuilder> flats = new ArrayList<FlatBuilder>();

 public void setNumber(int number) {
     this.number = positiveTest(number);
 }
    public int getNumber() {
        return number;
    }

    public void setFlatCount(int flatCount) {
        this.flatCount = positiveTest(flatCount);
    }
    public int getFlatCount() {
        return flatCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = positiveTest(floorCount);
    }
    public int getFloorCount() {
        return floorCount;
    }

    public HouseBuilder(int number, int flatCount, int floorCount) {
        setFlatCount(flatCount);
        setFloorCount(floorCount);
        setNumber(number);
    }
    public int positiveTest(int verifiable) {
        if (verifiable >= 0) {
            return verifiable;
        } else {
            return 1;
        }
    }
    public HouseBuilder() {
    }

    public Collection<Object> getFlat() {
     return Collections.singleton(1);
    }
}
