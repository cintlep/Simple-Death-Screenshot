package cintlex.sds;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleDeathScreenshot implements ClientModInitializer {
	public static final String MOD_ID = "simpledeathscreenshot";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitializeClient() {
		LOGGER.info("Ready to screenshot");
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			ClientPlayerEntity player = client.player;

			if (player != null && player.isDead() && player.deathTime == 19) {
				screenshot(client);
			}
		});
	}
	private void screenshot(MinecraftClient client) {
		ScreenshotRecorder.saveScreenshot(client.runDirectory, client.getFramebuffer(), (text) -> {
		});
	}
}