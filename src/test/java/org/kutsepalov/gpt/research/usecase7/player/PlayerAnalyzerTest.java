package org.kutsepalov.gpt.research.usecase7.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerAnalyzerTest {

    private final PlayerAnalyzer testable = new PlayerAnalyzer();

    private Player firstPlayer;
    private Player secondPlayer;
    private Player thirdPlayer;

    private final double firstPlayerScore = 250;
    private final double secondPlayerScore = 67.5;
    private final double thirdPlayerScore = 2520;

    @BeforeEach
    void setUp() {
        firstPlayer = Player.of(25, 5, List.of(2, 2, 2));
        secondPlayer = Player.of(15, 3, List.of(3, 3, 3));
        thirdPlayer = Player.of(35, 15, List.of(4, 4, 4));
    }

    @Test
    @DisplayName("Normal Player")
    void shouldReturnRightScore1() {
        double result = testable.calculateScore(List.of(firstPlayer));
        assertEquals(firstPlayerScore, result);
    }

    @Test
    @DisplayName("Junior Player")
    void shouldReturnRightScore2() {
        double result = testable.calculateScore(List.of(secondPlayer));
        assertEquals(secondPlayerScore, result);
    }

    @Test
    @DisplayName("Senior Player")
    void shouldReturnRightScore3() {
        double result = testable.calculateScore(List.of(thirdPlayer));
        assertEquals(thirdPlayerScore, result);
    }

    @Test
    @DisplayName("Multiple Players")
    void shouldReturnRightScore4() {
        final double commonScore = firstPlayerScore + secondPlayerScore + thirdPlayerScore;

        double result = testable.calculateScore(List.of(firstPlayer, secondPlayer, thirdPlayer));
        assertEquals(commonScore, result);
    }

    @Test
    @DisplayName("Skills is null")
    void exceptionShouldBeThrown() {
        firstPlayer.setSkills(null);
        List<Player> players = List.of(firstPlayer);

        assertThrows(NullPointerException.class, () -> testable.calculateScore(players));
    }

    @Test
    @DisplayName("Empty Array")
    void studentListShouldBeEmpty() {
        double result = testable.calculateScore(List.of());
        assertEquals(0, result);
    }
}