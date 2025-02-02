package ru.nwtls.gui;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.HashMap;
import java.util.UUID;

public class GuiManager {
    private final @NotNull HashMap<UUID, Gui> guis = new HashMap<>();

    public void createGUI(@NotNull Component title, @Range(from = 1, to = 6) int rows, @NotNull Player player) {
        this.guis.put(player.getUniqueId(), new Gui(title, rows, player));

        System.out.println("GUI created");
    }

    public @Nullable Gui getGUI(@NotNull UUID uuid) {
        return this.guis.get(uuid);
    }

    public void removeGUI(@NotNull UUID uuid) {
        this.guis.remove(uuid);

        System.out.println("GUI removed from manager");
    }

    // TODO: public void registerListeners() {}
    // TODO: should register listeners for GUI events
}