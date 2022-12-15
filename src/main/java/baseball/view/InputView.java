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
        return Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static GameCommand readReplay() {
        return GameCommand.replayByCommand(Console.readLine());
    }
}
