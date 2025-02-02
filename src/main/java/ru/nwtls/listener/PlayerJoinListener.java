package ru.nwtls.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;
import ru.nwtls.GUIExampleMain;
import ru.nwtls.gui.Gui;
import ru.nwtls.gui.GuiListener;
import ru.nwtls.gui.GuiManager;
import ru.nwtls.gui.event.ButtonClickEvent;
import ru.nwtls.gui.event.Event;
import ru.nwtls.gui.event.EventManager;

public class PlayerJoinListener implements Listener {
    private static final GUIExampleMain plugin = GUIExampleMain.getInstance();
    private static final GuiManager guiManager = plugin.getGUIManager();

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        guiManager.createGUI(Component.text("Goida"), 3, event.getPlayer());
        Gui gui = guiManager.getGUI(event.getPlayer().getUniqueId());
        gui.show();

        EventManager eventManager = new EventManager();
        eventManager.registerListener(new GuiListener());
        eventManager.callEvent(new ButtonClickEvent(event.getPlayer()));
    }
}
