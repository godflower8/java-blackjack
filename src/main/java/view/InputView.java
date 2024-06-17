package view;

import domain.Player;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static List<Player> requestPlayers() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return Stream.of(sc.nextLine().split(","))
                .map(Player::new).toList();
    }

    public static String requestHit(Player player){
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", player.getName());
        String response = sc.nextLine();
        if(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("N")){
            return response;
        }
        return requestHit(player);
    }

}
