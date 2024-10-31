package ru.nwtls.gui;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
import ru.nwtls.GUIExampleMain;
import ru.nwtls.gui.button.Button;
import ru.nwtls.gui.button.DecorativeButton;
import ru.nwtls.gui.button.ExecutableButton;

import java.util.HashMap;

public class GUI {
    private final Inventory inventory;
    private final Player owner;
    private final int rows;
    private final Component title;
    private final @NotNull HashMap<Integer, Button> buttons;

    private static final GUIExampleMain plugin = GUIExampleMain.getInstance();

    protected GUI(@NotNull Component title, @Range(from = 1, to = 6) int rows, @NotNull Player player) {
        this.rows = rows;
        this.title = title;
        this.buttons = new HashMap<>();
        this.owner = player;
        this.inventory = Bukkit.createInventory(owner, this.rows * 9, title);
    }

    @Contract("_, _, _ -> this")
    public @NotNull GUI setButton(@Range(from = 1, to = 6) int row, @Range(from = 1, to = 9) int column, @NotNull ExecutableButton button) {
        this.inventory.setItem((row - 1) * 9 + column - 1, button.getItemStack());
        this.buttons.put((row - 1) * 9 + column - 1, button);
        return this;
    }

    @Contract("_, _, _ -> this")
    public @NotNull GUI setButton(@Range(from = 1, to = 6) int row, @Range(from = 1, to = 9) int column, @NotNull DecorativeButton button) {
        this.inventory.setItem((row - 1) * 9 + column - 1, button.getItemStack());
        this.buttons.put((row - 1) * 9 + column - 1, button);
        return this;
    }

    public void showGUI() {
        this.owner.openInventory(this.inventory);
        this.owner.setMetadata("gui", new FixedMetadataValue(plugin, true));

        System.out.println("gui showed");
    }

    public void closeGUI() {
        this.owner.removeMetadata("gui", plugin);

        System.out.println("gui closed");
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Component getTitle() {
        return this.title;
    }

    public int getRows() {
        return this.rows;
    }

    public @NotNull Player getOwner() {
        return this.owner;
    }

    public @NotNull Button getButtonById(int id) {
        return this.buttons.get(id);
    }

    public @NotNull HashMap<Integer, Button> getButtons() {
        return this.buttons;
    }
}
