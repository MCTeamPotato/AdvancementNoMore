package me.kall.advancementnomore.common.mixin;

import net.minecraft.advancements.AdvancementTree;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AdvancementTree.class)
public abstract class AdvancementTreeMixin {
    @Inject(method = {"remove(Ljava/util/Set;)V", "remove(Lnet/minecraft/advancements/AdvancementNode;)V", "addAll", "setListener"}, at = @At("HEAD"), cancellable = true)
    private void operate(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "tryInsert", at = @At("HEAD"), cancellable = true)
    private void operate(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
