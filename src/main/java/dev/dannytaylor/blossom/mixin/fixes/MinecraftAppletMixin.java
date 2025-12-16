/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.mixin.fixes;

import dev.dannytaylor.blossom.log.BlossomLogger;
import dev.dannytaylor.blossom.util.MinecraftFixes;
import net.minecraft.client.MinecraftApplet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftApplet.class)
public abstract class MinecraftAppletMixin {
//	@Redirect(method = "init", at = @At(value = "INVOKE", target = "Ljava/net/URL;getHost()Ljava/lang/String;"))
//	private String save$setProxy(URL proxy) {
//		return !proxy.getHost().equals("www.minecraft.net") ? proxy.getHost() : (SaveConfig.instance.proxyUrl.value().isEmpty() ? proxy.getHost() : SaveConfig.instance.proxyUrl.value());
//	}
//	@Redirect(method = "init", at = @At(value = "INVOKE", target = "Ljava/net/URL;getPort()I"))
//	private int save$setProxyPort(URL proxy) {
//		return !proxy.getHost().equals("www.minecraft.net") ? proxy.getPort() : (SaveConfig.instance.proxyUrl.value().isEmpty() ? proxy.getPort() : SaveConfig.instance.proxyPort.value());
//	}
	@Inject(method = "stop", at = @At(value = "HEAD"))
	private void save$stop(CallbackInfo ci) {
		BlossomLogger.get().debug("Forcing the game to close.");
		MinecraftFixes.exit(0);
	}
}
