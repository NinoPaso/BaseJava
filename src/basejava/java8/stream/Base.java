package basejava.java8.stream;


import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 的基本操作
 */
public class Base {
    public static void main(String[] args) {
        List<String> collected = Stream.of("1","e","1","5","c","3","a","k","9").collect(Collectors.toList());
        collected = collected.stream().filter(str -> {
            Pattern pattern = Pattern.compile("^-?[0-9]+");
            return pattern.matcher(str).matches();
        }).collect(Collectors.toList());
        collected.forEach(System.out::println);
    }
}
