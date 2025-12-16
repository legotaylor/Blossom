/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.mixin.gui.screen;

import dev.dannytaylor.blossom.config.BlossomConfig;
import dev.dannytaylor.blossom.gui.screen.DirectConnectScreen;
import dev.dannytaylor.blossom.gui.screen.MultiplayerScreen;
import net.minecraft.client.C_8938952;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(C_8938952.class)
public abstract class TitleScreenMixin extends Screen {
	@Redirect(method = "init", at = @At(value = "NEW", target = "(IIILjava/lang/String;)Lnet/minecraft/client/gui/widget/ButtonWidget;", ordinal = 2))
	private ButtonWidget blossom$replaceTutorialWithMultiplayer(int id, int x, int y, String message) {
		return new ButtonWidget(id, x, y, "Multiplayer");
	}

	@Inject(method = "init", at = @At("RETURN"))
	private void blossom$enableMultiplayerButton(CallbackInfo ci) {
		((ButtonWidget)this.buttons.get(2)).active = true;
	}

	@Inject(method = "buttonClicked", at = @At("HEAD"))
	private void blossom$onMultiplayerButtonClicked(ButtonWidget button, CallbackInfo ci) {
		if (button.id == 3) {
			this.minecraft.m_6408915(BlossomConfig.instance.reconnect.value().isEmpty() || BlossomConfig.instance.skipToDirectConnectScreen.value() ? new DirectConnectScreen(this) : new MultiplayerScreen(this));
		}
	}
}
