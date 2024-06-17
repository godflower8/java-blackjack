package view;

import domain.Player;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public static void printInitialProvide(Player... players){
        System.out.println("딜러와 ");
        System.out.println(Stream.of(players).map(Objects::toString)
                    .collect(Collectors.joining(",")));
        System.out.println("에게 2장의 나누었습니다.");
    }

    public static void printProvideResult(Player... players){

    }
}
