/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.gui;

import dev.dannytaylor.blossom.config.BlossomConfig;
import net.minecraft.client.C_5664496;
import net.minecraft.client.gui.screen.FatalErrorScreen;

public class ServerConnector {
	public static void connect(C_5664496 minecraft, String serverAddress) {
		BlossomConfig.instance.reconnect.setValue(serverAddress);

		String[] address = serverAddress.split(":");
		String server = address[0];
		int port = address.length > 1 ? Integer.parseInt(address[1]) : 25565;

		minecraft.m_6408915(new FatalErrorScreen("Connecting to server", server + ":" + port)); // TODO: Make a connection screen that initializes a connection to spore.
	}
}
