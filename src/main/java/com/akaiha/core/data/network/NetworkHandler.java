package com.akaiha.core.data.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class NetworkHandler implements Listener {
	
    @EventHandler
    public void onPluginMessage(PluginMessageEvent event){
    	if (event.getTag().equalsIgnoreCase("BungeeCord")) {
    		try {
            	DataInputStream in = new DataInputStream(new ByteArrayInputStream(event.getData()));
                JsonParser parser = new JsonParser();
                Object json = parser.parse(in.readUTF());
                if (json instanceof JsonObject) {
                	JsonObject jObj = (JsonObject) json;
                	if (jObj.has("channel")) {
                		Receive.executeCommand(jObj.get("channel").getAsString(), jObj);
                	}
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    	}
    }
}