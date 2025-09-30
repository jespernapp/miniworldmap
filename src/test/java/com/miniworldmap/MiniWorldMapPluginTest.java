package com.miniworldmap;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class MiniWorldMapPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MiniWorldMapPlugin.class);
		RuneLite.main(args);
	}
}