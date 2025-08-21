package xyz.bluspring.valhollclan.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import xyz.bluspring.valhollclan.client.ValhollClanClient;

@Mixin(PlayerTabOverlay.class)
public abstract class PlayerTabOverlayMixin {
    @ModifyReturnValue(method = "getNameForDisplay", at = @At("RETURN"))
    private Component tryAddClanInfoToName(Component original, @Local(argsOnly = true) PlayerInfo info) {
        return original.copy().append(ValhollClanClient.getClanIcon(info.getProfile()));
    }
}
