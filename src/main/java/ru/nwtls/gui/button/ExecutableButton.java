package ru.nwtls.gui.button;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ExecutableButton extends Button{
    public ExecutableButton(@NotNull ItemStack item, @NotNull Component title) {
        super(item, title);
    }
}
