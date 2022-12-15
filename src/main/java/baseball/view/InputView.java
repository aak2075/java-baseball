package baseball.view;

import baseball.util.GameCommand;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<Integer> readNumbers() {
        String input = Console.readLine();
        String[] arr = input.split("");
        try {
            return Arrays.stream(arr)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ERROR 숫자가 아닙니다.");
        }

    }

    public static GameCommand readReplay() {
        return GameCommand.replayByCommand(Console.readLine());
    }
}
