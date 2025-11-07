package com.storydokkebi;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import com.storydokkebi.ui.StoryScreen;

public class StoryClient implements ClientModInitializer {
    private static KeyBinding key;

    @Override
    public void onInitializeClient() {
        key = KeyBindingHelper.registerKeyBinding(
            new KeyBinding("key.story.open", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Y, "StoryDokkebi")
        );
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (key.wasPressed()) client.setScreen(new StoryScreen());
        });
    }
}