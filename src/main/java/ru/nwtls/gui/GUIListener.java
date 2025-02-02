package ru.nwtls.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import ru.nwtls.GUIExampleMain;
import ru.nwtls.gui.event.ButtonClickEvent;
import ru.nwtls.gui.event.EventListener;

public class GuiListener implements Listener, ru.nwtls.gui.event.Listener {
    private static final GUIExampleMain plugin = GUIExampleMain.getInstance();
    private static final GuiManager guiManager = plugin.getGUIManager();

//    @EventHandler
//    public void onInventoryClick(@NotNull InventoryClickEvent event) {
//        Player player = (Player) event.getWhoClicked();
//        GUI gui = guiManager.getGUI(player.getUniqueId());
//
//        if (event.getClickedInventory() == null || gui == null || !player.hasMetadata("gui")) return;
//        event.setCancelled(true);
//        player.sendMessage(MiniMessage.miniMessage().deserialize("<blue> Не кликай"));
//    }
//
//    @EventHandler
//    public void onClose(@NotNull InventoryCloseEvent event) {
//        Player player = (Player) event.getPlayer();
//        GUI gui = guiManager.getGUI(player.getUniqueId());
//        if (gui != null) {
//            gui.closeGUI();
//            guiManager.removeGUI(player.getUniqueId());
//        }
//    }
//
//    @EventHandler
//    public void onPlayerLeave(@NotNull PlayerQuitEvent event) {
//        Player player = event.getPlayer();
//        GUI gui = guiManager.getGUI(player.getUniqueId());
//        if (gui != null) gui.closeGUI();
//        guiManager.removeGUI(player.getUniqueId());
//    }

    @EventListener
    public void onButtonClick(@NotNull ButtonClickEvent event) {
        System.out.println("Button clicked by " + event.getAuthor().getName());
    }
}
