/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.gui.screen;

import com.mojang.blaze3d.vertex.BufferBuilder;
import dev.dannytaylor.blossom.config.BlossomConfig;
import dev.dannytaylor.blossom.gui.ServerConnector;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

public class DirectConnectScreen extends Screen {
	private final Screen parent;
	private String serverAddress;

	public DirectConnectScreen(Screen parent, String defaultIpText) {
		this.parent = parent;
		this.serverAddress = defaultIpText;
	}

	public DirectConnectScreen(Screen parent) {
		this(parent, BlossomConfig.instance.skipToDirectConnectScreen.value() ? BlossomConfig.instance.reconnect.value() : "");
	}

	public final void init() {
		this.buttons.clear();
		this.buttons.add(new ButtonWidget(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Join Server"));
		this.buttons.add(new ButtonWidget(1, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
		((ButtonWidget)this.buttons.get(0)).active = false;
	}

	protected final void buttonClicked(ButtonWidget button) {
		if(button.active) {
			if(button.id == 1) {
				this.minecraft.m_6408915(this.parent);
			} else if(button.id == 0) {
				ServerConnector.connect(this.minecraft, this.serverAddress);
			}
		}
	}

	@Override
	protected void keyPressed(char chr, int key) {
		if (chr == 22) {
			String string3 = Sys.getClipboard();
			int i4 = 32 - this.serverAddress.length();
			if (i4 > string3.length()) {
				i4 = string3.length();
			}

			if (i4 > 0) {
				this.serverAddress = this.serverAddress + string3.substring(0, i4);
			}
		}

		if (key == 14 && !this.serverAddress.isEmpty()) {
			this.serverAddress = this.serverAddress.substring(0, this.serverAddress.length() - 1);
		}

		if (" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(chr) >= 0 && this.serverAddress.length() < 32) {
			this.serverAddress = this.serverAddress + chr;
		}

		((ButtonWidget)this.buttons.get(0)).active = !this.serverAddress.isEmpty();
	}

	public final void render(int mouseX, int mouseY, float tickDelta) {
		this.drawBackgroundTexture();
		int i4 = this.width / 2 - 100;
		int i5 = this.height / 4 - 10 + 50 + 18;
		drawCenteredString(this.textRenderer, "Direct Connect", this.width / 2, this.height / 4 - 60 + 20, 0xFFFFFF);
		drawString(this.textRenderer, "Server Address", i4, this.height / 4 - 60 + 60 + 36, 10526880);
		BufferBuilder var4 = BufferBuilder.INSTANCE;
		GL11.glBindTexture(3553, this.minecraft.f_9413506.load("/assets/sporeblossom-client/atlases/multiplayer.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var4.color(16777215);
		drawTexture(i4, i5, 0, 0, 200, 20);
		drawString(this.textRenderer, this.serverAddress + "_", i4 + 4, i5 + 12 / 2, 14737632);
		super.render(mouseX, mouseY, tickDelta);
	}
}
