package ru.nwtls.gui.event;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ButtonClickEvent extends Event {
    private final @NotNull Player author;
    public ButtonClickEvent(@NotNull Player author) {
        this.author = author;
    }

    public @NotNull Player getAuthor() {
        return this.author;
    }
}
