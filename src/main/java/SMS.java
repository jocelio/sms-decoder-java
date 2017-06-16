import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jocelio.lima on 6/15/2017.
 */
public class SMS {

    final List<String> alphabet = IntStream.rangeClosed('A', 'Z').mapToObj(c -> "" + (char) c).collect(Collectors.toList());

    public String getMessage(String input){

        return Stream.of(input.split("(?<=(.))(?!\\1)")).map(f -> new Key(f.charAt(0), f.length()))
                .filter(s -> s.key >= 0)
                .map(i -> {
                    if (i.key == 1) return "";
                    if (i.key == 0) return " ";
                    return alphabet.get(getFirstLetterPosition(i.key) + (i.pushes - 1));
                }).collect(Collectors.joining());

    }

    private int getFirstLetterPosition(int T){
        return (T >= 8)? ((T - 2) * 3) +1 : (T - 2) * 3;
    }

    class Key {

        public int key, pushes;

        public Key(int key, int pushes) {
            this.key = Character.getNumericValue(key) ;
            this.pushes = pushes;
        }
    }
}
