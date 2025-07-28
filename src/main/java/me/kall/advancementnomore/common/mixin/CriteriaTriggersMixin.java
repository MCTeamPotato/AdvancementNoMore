package me.kall.advancementnomore.common.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CriteriaTriggers.class)
public abstract class CriteriaTriggersMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Registry;register(Lnet/minecraft/core/Registry;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;"))
    private static Object init(Registry<Object> registry, String name, Object value) {
        return value;
    }
}
