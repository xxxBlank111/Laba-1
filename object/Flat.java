package object;
import builders.FlatBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import computation.Comput;
import builders.FlatBuilder;


public class Flat {

    private FlatBuilder flat;

    public Flat() {}

    public static Map<String,Character> compareFlat(FlatBuilder One,FlatBuilder Two) {
        Map<String,Character> result = new HashMap<>();
        result.put("square",Comput.getSign(One.getSquare(),Two.getSquare()));
        result.put("roomers",Comput.getSign(One.getRoomer(),Two.getRoomer()));
        result.put("humans",Comput.getSign(One.getHumans(),Two.getHumans()));
        result.put("floor",Comput.getSign(One.getFloor(),Two.getFloor()));
        return Collections.unmodifiableMap(result);
    }
    public Map<String,Integer> getInfo() {
        Map<String,Integer> flatInfo = new HashMap<>();
        flatInfo.put("number",flat.getNumber());
        flatInfo.put("square",flat.getSquare());
        flatInfo.put("roomer",flat.getRoomer());
        flatInfo.put("humans",flat.getHumans());
        flatInfo.put("floor",flat.getFloor());
        return Collections.unmodifiableMap(flatInfo);
    }
}