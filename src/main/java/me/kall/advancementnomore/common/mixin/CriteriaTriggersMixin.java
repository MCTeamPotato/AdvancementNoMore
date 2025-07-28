package me.kall.advancementnomore.common.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(CriteriaTriggers.class)
public abstract class CriteriaTriggersMixin {
    @Redirect(method = "register", at = @At(value = "INVOKE", target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false))
    private static @Nullable Object operate(Map<?, ?> instance, Object k, Object v) {
        return null;
    }
}
