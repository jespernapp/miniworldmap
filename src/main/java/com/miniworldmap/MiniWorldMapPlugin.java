package com.miniworldmap;

import com.google.inject.Provides;
import javax.inject.Inject;

import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Mini World Map",
		description = "Replaces the minimap with a small world map overlay",
		tags = {"map", "world", "minimap"}
)
public class MiniWorldMapPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MiniWorldMapOverlay overlay;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Provides
	MiniWorldMapConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MiniWorldMapConfig.class);
	}
}