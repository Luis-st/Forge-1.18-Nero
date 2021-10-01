package net.luis.nero.api.common.world.biome;

import net.luis.nero.api.common.world.levelgen.INoiseType;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public interface IForestBiomeType {
	
	float getTemperature();
	
	double getBaseNoise();
	
	double getNoiseScale();
	
	INoiseType getNoiseType();
	
	MobSpawnSettings getMobSpawnSettings();
	
	BiomeGenerationSettings getBiomeGenerationSettings();
	
	boolean isIsland();
	
	boolean isHilly();
	
	boolean isMountain();
	
}