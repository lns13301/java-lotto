package lotto.view;

import lotto.domain.Rewords;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String DELIMITER_HEAD = "[";
    private static final String DELIMITER_TAIL = "]";
    private static final String CONTOUR = "---------";

    public static void printInputMoneyMessage() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    public static void printBuyLottoCountMessage(final int value) {
        System.out.printf("%s개를 구매했습니다.%n", value);
    }

    public static void printLottoNumbersMessage() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusBallMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printLottoMessage(List<Integer> values) {
        String numbers = values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));

        System.out.printf("%s %s %s%n", DELIMITER_HEAD, numbers, DELIMITER_TAIL);
    }

    public static void printNewLineMessage() {
        System.out.println();
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println(CONTOUR);

    }

    public static void printReword(int hitCount, long reword, long profit) {
        System.out.printf("%d개 일치 (%d원)- %d%n", hitCount, reword, profit);
    }

    public static void printProfit(final Rewords rewords, final int money) {
        System.out.printf("총 수익률은 %.2f 입니다.%n", rewords.profit(money));
    }
}
