package net.luis.nero.common.world.biome.vanilla.overworld.type;

import net.luis.nero.api.common.world.biome.IBiomeType;
import net.luis.nero.api.common.world.biome.noise.OverworldBiomeNoise;
import net.luis.nero.api.common.world.biome.noise.IBiomeNoise;
import net.luis.nero.api.common.world.biome.util.BiomeGenerationBuilder;
import net.luis.nero.api.common.world.biome.util.MobSpawnBuilder;
import net.luis.nero.common.world.biome.util.BiomeSettings;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public enum SavannaBiomeType implements IBiomeType {
	
	SAVANNA(1.2F, OverworldBiomeNoise.of(0.125, 0.05), BiomeSettings.getSavannaSpawns(false), BiomeSettings.getSavannaFeatures(false, false), false, false),
	WINDSWEPT_SAVANNA(1.0F, OverworldBiomeNoise.of(1.5, 0.025), BiomeSettings.getSavannaSpawns(true), BiomeSettings.getSavannaFeatures(true, false), false, true),
	SHATTERED_SAVANNA(1.1F, OverworldBiomeNoise.of(0.3625, 1.225), BiomeSettings.getSavannaSpawns(false), BiomeSettings.getSavannaFeatures(true, true), true, true),
	SHATTERED_WINDSWEPT_SAVANNA(1.0F, OverworldBiomeNoise.of(1.05, 1.2125001), BiomeSettings.getSavannaSpawns(true), BiomeSettings.getSavannaFeatures(true, true), true, true);
	
	private final float temperature;
	private final IBiomeNoise biomeNoise;
	private final MobSpawnSettings mobSettings;
	private final BiomeGenerationSettings generationSettings;
	private final boolean hilly;
	private final boolean windswept;
	
	private SavannaBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnBuilder mobBuilder, BiomeGenerationBuilder generationBuilder, boolean hilly, boolean windswept) {
		this(temperature, biomeNoise, mobBuilder.build(), generationBuilder.build(), hilly, windswept);
	}
	
	private SavannaBiomeType(float temperature, IBiomeNoise biomeNoise, MobSpawnSettings mobSettings, BiomeGenerationSettings generationSettings, boolean hilly, boolean windswept) {
		this.temperature = temperature;
		this.biomeNoise = biomeNoise;
		this.mobSettings = mobSettings;
		this.generationSettings = generationSettings;
		this.hilly = hilly;
		this.windswept = windswept;
	}
	
	@Override
	public float getTemperature() {
		return this.temperature;
	}
	
	@Override
	public IBiomeNoise getBiomeNoise() {
		return this.biomeNoise;
	}
	
	@Override
	public MobSpawnSettings getMobSpawnSettings() {
		return this.mobSettings;
	}
	
	@Override
	public BiomeGenerationSettings getBiomeGenerationSettings() {
		return this.generationSettings;
	}
	
	@Override
	public boolean isUnderground() {
		return false;
	}
	
	@Override
	public boolean isOcean() {
		return false;
	}
	
	@Override
	public boolean isBeach() {
		return false;
	}
	
	@Override
	public boolean isMushroomIsland() {
		return false;
	}
	
	@Override
	public boolean isHilly() {
		return this.hilly;
	}

	@Override
	public boolean isWindswept() {
		return this.windswept;
	}
	
}