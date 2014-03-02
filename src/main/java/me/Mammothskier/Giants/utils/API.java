package main.java.me.Mammothskier.Giants.utils;

import java.util.List;

import main.java.me.Mammothskier.Giants.Commands;
import main.java.me.Mammothskier.Giants.Giants;
import main.java.me.Mammothskier.Giants.events.GiantListeners;
import main.java.me.Mammothskier.Giants.events.MagmaCubeListeners;
import main.java.me.Mammothskier.Giants.events.SlimeListeners;
import main.java.me.Mammothskier.Giants.files.FileHandler;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Slime;

public class API {
	private static Giants _giants;
	private static Giants _slimes;
	private static Giants _magmacubes;
	private Commands commands;
	private static FileHandler fileHandler;

	public API(Giants giants) {
		_giants = giants;
		_slimes = giants;
		_magmacubes = giants;
		new GiantListeners(_giants);
		new SlimeListeners(_slimes);
		new MagmaCubeListeners(_magmacubes);
		commands = new Commands(_giants);
		_giants.getCommand("giants").setExecutor(commands);
		fileHandler = new FileHandler(_giants);
	}

	public static boolean isGiant(Entity entity) {
		return entity instanceof Giant;
	}

	public static boolean isGiant(LivingEntity livingEntity) {
		return livingEntity instanceof Giant;
	}
	
	public static boolean isGiantSlime(Entity entity) {
		return entity instanceof Slime;
	}

	public static boolean isGiantSlime(LivingEntity livingEntity) {
		return livingEntity instanceof Slime;
	}
	
	public static boolean isGiantMagmaCube(Entity entity) {
		return entity instanceof MagmaCube;
	}
	
	public static boolean isGiantMagmaCube(LivingEntity livingEntity) {
		return livingEntity instanceof MagmaCube;
	}

	public static List<String> getGiantSpawnWorlds() {
		return getFileHandler().getGiantPropertyList(main.java.me.Mammothskier.Giants.files.Giant.GIANT, "Giants Configuration.Spawn Settings.Worlds");
	}
	
	public static List<String> getSlimeSpawnWorlds() {
		return getFileHandler().getSlimePropertyList(main.java.me.Mammothskier.Giants.files.Slime.SLIME, "Giants Configuration.Spawn Settings.Worlds");
	}
	
	public static List<String> getMagmaCubeSpawnWorlds() {
		return getFileHandler().getMagmaCubePropertyList(main.java.me.Mammothskier.Giants.files.MagmaCube.MAGMACUBE, "Giants Configuration.Spawn Settings.Worlds");
	}

	public static FileHandler getFileHandler() {
		return fileHandler;
	}
}