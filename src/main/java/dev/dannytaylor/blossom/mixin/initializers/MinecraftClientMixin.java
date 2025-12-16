/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.mixin.initializers;

import dev.dannytaylor.blossom.BlossomMain;
import net.minecraft.client.C_5664496;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(C_5664496.class)
public abstract class MinecraftClientMixin {
	@Inject(method = "run", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GameGui;<init>(Lnet/minecraft/client/C_5664496;)V", shift = At.Shift.AFTER))
	private void blossom$onInit(CallbackInfo ci) {
		BlossomMain.onInitializeClient();
	}
}
