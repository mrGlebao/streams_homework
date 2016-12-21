import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zabor on 22.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){{add(1);add(2); add(3);add(4);}};

        Map m = Streams.of(list)
                .filter(p -> p > 2)
                .transform( p -> p + 1)
                .toMap(p -> p, Object::toString);



    }
}
