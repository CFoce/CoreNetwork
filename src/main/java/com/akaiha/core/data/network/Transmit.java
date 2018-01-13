package com.akaiha.core.data.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import net.md_5.bungee.api.config.ServerInfo;

public class Transmit {

	public static void send(ServerInfo server, JsonObject jObj) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);
        try {
        	out.writeUTF(new Gson().toJson(jObj));
        	server.sendData("Return", stream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
