package ru.nwtls.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;
import ru.nwtls.GUIExampleMain;
import ru.nwtls.gui.GUI;
import ru.nwtls.gui.GUIManager;

public class EventListener implements Listener {
    private static final GUIExampleMain plugin = GUIExampleMain.getInstance();
    private static final GUIManager guiManager = plugin.getGUIManager();

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        guiManager.createGUI(Component.text("Goida"), 3, event.getPlayer());
        GUI gui = guiManager.getGUI(event.getPlayer().getUniqueId());
        gui.showGUI();
    }
}
