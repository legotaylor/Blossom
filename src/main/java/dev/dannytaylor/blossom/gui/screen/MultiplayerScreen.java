/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.gui.screen;

import dev.dannytaylor.blossom.config.BlossomConfig;
import dev.dannytaylor.blossom.gui.ServerConnector;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;

public class MultiplayerScreen extends Screen {
	private final Screen parent;

	public MultiplayerScreen(Screen parent) {
		this.parent = parent;
	}

	public final void init() {
		this.buttons.clear();
		this.buttons.add(new ButtonWidget(0, this.width / 2 - 100, this.height / 4 + 72, "Reconnect"));
		this.buttons.add(new ButtonWidget(1, this.width / 2 - 100, this.height / 4 + 48, "Direct Connect"));
		this.buttons.add(new ButtonWidget(200, this.width / 2 - 100, this.height / 6 + 168, "Done"));

		((ButtonWidget)this.buttons.get(0)).active = !BlossomConfig.instance.reconnect.value().isEmpty();
	}

	protected final void buttonClicked(ButtonWidget button) {
		if (button.active) {
			if (button.id == 0) {
				ServerConnector.connect(this.minecraft, BlossomConfig.instance.reconnect.value());
			} else if (button.id == 1) {
				this.minecraft.m_6408915(new DirectConnectScreen(this));
			} else if (button.id == 200) {
				this.minecraft.m_6408915(this.parent);
			}
		}
	}

	public final void render(int mouseX, int mouseY, float tickDelta) {
		this.drawBackgroundTexture();
		drawCenteredString(this.textRenderer, "Multiplayer", this.width / 2, this.height / 4 - 60 + 20, 0xFFFFFF);
		super.render(mouseX, mouseY, tickDelta);
	}
}
