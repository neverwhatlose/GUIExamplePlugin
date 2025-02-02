package ru.nwtls.gui.event;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final @NotNull List<Listener> listeners = new ArrayList<>();

    public void registerListener(@NotNull Listener listener) {
        listeners.add(listener);
    }

    public void unregisterListener(@NotNull Listener listener) {
        listeners.remove(listener);
    }

    public @NotNull List<Listener> getListeners() {
        return listeners;
    }

    public void callEvent(@NotNull Event event) {
        for (Listener listener : listeners) {
            Method[] methods = listener.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(EventListener.class)) {
                    if (method.getParameterTypes().length == 1 && method.getParameterTypes()[0].equals(event.getClass())) {
                        try {
                            method.invoke(listener, event);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
