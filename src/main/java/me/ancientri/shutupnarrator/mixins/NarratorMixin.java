package me.ancientri.shutupnarrator.mixins;

import com.mojang.text2speech.Narrator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = {Narrator.class}, remap = false)
public interface NarratorMixin {
	@Inject(method = "getNarrator", at = @At("HEAD"), cancellable = true, remap = false)
	private static void onGetNarrator(CallbackInfoReturnable<Narrator> cir) {
		cir.setReturnValue(Narrator.EMPTY);
	}
}
