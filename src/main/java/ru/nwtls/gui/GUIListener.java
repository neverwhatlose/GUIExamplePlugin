package ru.nwtls.gui;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import ru.nwtls.GUIExampleMain;

public class GUIListener implements Listener {
    private static final GUIExampleMain plugin = GUIExampleMain.getInstance();
    private static final GUIManager guiManager = plugin.getGUIManager();

    @EventHandler
    public void onInventoryClick(@NotNull InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        GUI gui = guiManager.getGUI(player.getUniqueId());

        if (event.getClickedInventory() == null || gui == null || !player.hasMetadata("gui")) return;
        event.setCancelled(true);
        player.sendMessage(MiniMessage.miniMessage().deserialize("<blue>Не кликай"));
    }

    @EventHandler
    public void onClose(@NotNull InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        GUI gui = guiManager.getGUI(player.getUniqueId());
        if (gui != null) {
            gui.closeGUI();
            guiManager.removeGUI(player.getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerLeave(@NotNull PlayerQuitEvent event) {
        Player player = event.getPlayer();
        GUI gui = guiManager.getGUI(player.getUniqueId());
        if (gui != null) gui.closeGUI();
        guiManager.removeGUI(player.getUniqueId());
    }
}
