import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zabor on 22.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>(){{add(1L);add(2L); add(3L);add(4L);}};

        Map<Integer, String> m = Streams.of(list)
                .filter(p -> p > 1)
                .transform(list::indexOf)
                .toMap(p -> p, Object::toString);
    }
}
