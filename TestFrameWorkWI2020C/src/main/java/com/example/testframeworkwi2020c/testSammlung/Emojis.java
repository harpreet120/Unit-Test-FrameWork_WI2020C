package com.example.testframeworkwi2020c.testSammlung;

import java.nio.charset.Charset;

public enum Emojis {
    SMIRKING("\uD83D\uDE0F"),
    BAUSTELLE("\uD83D\uDEA7"),
    FALSCH("\u274C"),
    RICHTIG("\u2714");

    private final String emoji;

    private Emojis(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}
