package ru.nwtls.gui.button;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class Button {
    private final ItemStack item;

    public Button(@NotNull ItemStack item, @NotNull Component title) {
        this.item = item;
        this.item.editMeta(meta -> meta.displayName(title));
    }

    public @NotNull ItemStack getItemStack() {
        return this.item;
    }

    public @NotNull String getTitle(){
        return ((TextComponent) (this.getItemStack().getItemMeta().displayName())).content();
    }
}
