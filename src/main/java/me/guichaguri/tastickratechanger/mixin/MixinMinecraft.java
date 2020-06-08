package me.guichaguri.tastickratechanger.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import me.guichaguri.tastickratechanger.TickrateChanger;
import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
	
	@ModifyConstant(method = "runTickMouse", constant= {@Constant(longValue=200L)})
	private long fixMouseWheel(long ignored) {
		return (long)Math.max(4000F/TickrateChanger.TICKS_PER_SECOND, 200L);
	}
}
	