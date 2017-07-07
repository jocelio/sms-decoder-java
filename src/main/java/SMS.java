import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SMS {

    private final List<String> alphabet = IntStream.rangeClosed('A', 'Z').mapToObj(c -> "" + (char) c).collect(Collectors.toList());

    private String numerosDigitados;

    public SMS(String numerosDigitados) {
        this.numerosDigitados = numerosDigitados;
    }

    public String texto(){

        return Stream.of(numerosDigitados.split("(?<=(.))(?!\\1)")).map(f -> new Key(f.charAt(0), f.length()))
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
