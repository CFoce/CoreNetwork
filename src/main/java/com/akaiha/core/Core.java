package com.akaiha.core;

import com.akaiha.core.data.network.NetworkHandler;

import net.md_5.bungee.api.plugin.Plugin;

public class Core extends Plugin {

	private NetworkHandler nh;
	
	public void onEnable() {
		getProxy().registerChannel("Return");
		getProxy().getPluginManager().registerListener(this, nh = new NetworkHandler());
		
	}

	public void onDisable() {
		getProxy().unregisterChannel("Return");
		getProxy().getPluginManager().unregisterListener(nh);
	}
}