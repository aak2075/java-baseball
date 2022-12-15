package baseball.util;

import java.util.Arrays;

public enum GameCommand {
    REPLAY("1"),
    QUIT("2");

    private final String input;

    GameCommand(String input) {
        this.input = input;
    }

    public static GameCommand replayByCommand(String input) {
        return Arrays.stream(GameCommand.values())
                .filter(command -> command.input.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
