package me.ancientri.shutupnarrator.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@WrapOperation(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/NarratorManager;checkNarratorLibrary(Z)V"), remap = false)
	private void onCheckNarratorLibrary(NarratorManager instance, boolean narratorEnabled, Operation<Void> original) {
		// Prevent the narrator library from being checked
	}
}
