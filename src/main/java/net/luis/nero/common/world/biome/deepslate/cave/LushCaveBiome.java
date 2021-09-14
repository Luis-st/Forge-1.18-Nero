package net.luis.nero.common.world.biome.deepslate.cave;

import net.luis.nero.api.util.annotation.NotTested;
import net.luis.nero.common.world.biome.deepslate.DeepslateBiome;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;

public class LushCaveBiome extends DeepslateBiome {
	
	@Override
	public float getTemperature() {
		return 1.5F;
	}
	
//	@Override
//	public BiomeSpecialEffects getBiomeEffects() {
//		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
//		specialEffectsBuilder.waterColor(4169444);
//		specialEffectsBuilder.waterFogColor(332595);
//		specialEffectsBuilder.fogColor(9352375);
//		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
//		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
//		specialEffectsBuilder.grassColorOverride(4710195);
//		specialEffectsBuilder.foliageColorOverride(1756928);
//		return specialEffectsBuilder.build();
//	}
	
	@Override
	@NotTested
	public BiomeSpecialEffects getBiomeEffects() {
		BiomeSpecialEffects.Builder specialEffectsBuilder = new BiomeSpecialEffects.Builder();
		specialEffectsBuilder.waterColor(4159204);
		specialEffectsBuilder.waterFogColor(329011);
		specialEffectsBuilder.fogColor(12638463);
		specialEffectsBuilder.skyColor(this.calculateSkyColor(0.8F));
		specialEffectsBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
		specialEffectsBuilder.grassColorOverride(65280);
		specialEffectsBuilder.foliageColorOverride(5877296);
		return specialEffectsBuilder.build();
	}

}