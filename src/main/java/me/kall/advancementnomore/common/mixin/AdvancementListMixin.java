package me.kall.advancementnomore.common.mixin;

import net.minecraft.advancements.AdvancementList;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AdvancementList.class)
public abstract class AdvancementListMixin {
    @Inject(method = {"remove(Lnet/minecraft/advancements/Advancement;)V", "remove(Ljava/util/Set;)V", "add", "clear", "setListener"}, at = @At("HEAD"), cancellable = true)
    private void operate(@NotNull CallbackInfo ci) {
        ci.cancel();
    }
}
