package me.kall.advancementnomore.common.mixin;

import net.minecraft.server.PlayerAdvancements;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerAdvancements.class)
public abstract class PlayerAdvancementsMixin {
    @Inject(method = {"load", "save", "flushDirty", "setSelectedTab"}, at = @At("HEAD"), cancellable = true)
    private void operate(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = {"award", "revoke"}, at = @At("HEAD"), cancellable = true)
    private void award(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
