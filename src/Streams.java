import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by zabor on 20.12.2016.
 */
//T: figure -> T ELLIPSE -> sphere
public class Streams<T> {
    Collection<? extends T> innerCollection;

    public Streams(Collection<? extends T> coll){
        this.innerCollection = coll;
    }

    public static<T> Streams<T> of(List<? extends T> list) {
    return new Streams<>(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> list = new ArrayList<T>();
        for(T elem : innerCollection){
            if(predicate.test(elem)){
                list.add(elem);
            }
        }
        this.innerCollection = list;
        return this;
    }

    public<R> Streams<R> transform(Function<? super T, ? extends R> mapper) {
        List<R> list = new ArrayList<>();
        for(T elem : innerCollection){
            list.add(mapper.apply(elem));
            }
        return new Streams<R>(list);
        }


    public<K, V> Map<K, V> toMap(Function<? super T, K> keyFunc, Function<? super T, V> valueFunc) {
        Map<K, V> map = new HashMap<>();
        for(T elem : innerCollection){
            map.put(keyFunc.apply(elem), valueFunc.apply(elem));
        }
        return map;
    }

}

