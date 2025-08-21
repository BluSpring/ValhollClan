package xyz.bluspring.valhollclan.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import xyz.bluspring.valhollclan.client.ValhollClanClient;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @Shadow
    public abstract GameProfile getGameProfile();

    @ModifyReturnValue(method = "getDisplayName", at = @At("RETURN"))
    private Component tryAddClanInfoToName(Component original) {
        return original.copy().append(ValhollClanClient.getClanIcon(this.getGameProfile()));
    }
}
