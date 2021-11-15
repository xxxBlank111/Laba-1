package computation;
import main.AccountingSystem;
public class Comput {
    public static String getSign(int x, int y) {
        switch (Integer.compare(x, y)) {
            case 1 -> {
                return x + " > " + y;
            }
            case 0 -> {
                return x + " = " + y;
            }
            case -1 -> {
                return x + " < " + y;
            }
        }
        return "";
    }
    public static int FloorCount(int x) {
        int y = x;
        int i = 0;
        while (y >= 3) {
            if (i == 0)
                y -= 2;
            else
                y -= 3;
            i++;
        }
        return i + 1;
    }
    public static int FloorCountFlat(int x) {
        x =-2;
        int i=0;
        for (int y=0;x >= 3;y++)
        {
            x=-3;
            i=y;
        }
        return i+1;
    }
}