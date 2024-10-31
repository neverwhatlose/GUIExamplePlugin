package ru.nwtls.gui;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.HashMap;
import java.util.UUID;

public class GUIManager {
    private final @NotNull HashMap<UUID, GUI> guis;

    public GUIManager() {
        this.guis = new HashMap<>();
    } //btw it should be empty I guess

    public void createGUI(@NotNull Component title, @Range(from = 1, to = 6) int rows, @NotNull Player player) {
        this.guis.put(player.getUniqueId(), new GUI(title, rows, player));
    }

    public @Nullable GUI getGUI(@NotNull UUID uuid) {
        return this.guis.get(uuid);
    }

    public void removeGUI(@NotNull UUID uuid) {
        this.guis.remove(uuid);
    }
}