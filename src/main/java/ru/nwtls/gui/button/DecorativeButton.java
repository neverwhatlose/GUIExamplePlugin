package ru.nwtls.gui.button;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DecorativeButton extends Button {
    public DecorativeButton(@NotNull ItemStack item, @NotNull Component title) {
        super(item, title);
    }
}
