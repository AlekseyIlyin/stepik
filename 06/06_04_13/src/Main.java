import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.
 Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.
 Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // + debug
        final String exampleString = "Мама мыла-мыла-мыла раму!";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(exampleString.getBytes());
        System.setIn(byteArrayInputStream);
        // - debug

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringLine = null;
        List<String> strings = new ArrayList<>();
        while ((stringLine = bufferedReader.readLine()) != null) {
            strings.add(stringLine);
        }

        //Stream<String> stringStream =
        strings.stream()
                .map(s -> s.toLowerCase())
                .flatMap(x -> Arrays.stream(x.split("[^a-zа-я\\d]")))
                .forEach(System.out::println);

    }
}