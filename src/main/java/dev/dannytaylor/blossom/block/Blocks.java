/*
    Blossom
    Contributor(s): dannytaylor
    Github: https://github.com/legotaylor/blossom
    Licence: LGPL-3.0-or-later
*/

package dev.dannytaylor.blossom.block;

import dev.dannytaylor.blossom.log.BlossomLogger;
import dev.dannytaylor.spore.identifier.Identifier;

import java.util.HashMap;
import java.util.Map;

public class Blocks {
	private static final Map<Identifier, Integer> idToInt = new HashMap<>();
	private static final Map<Integer, Identifier> intToId = new HashMap<>();

	public static int get(Identifier id) {
		return idToInt.get(id);
	}

	public static Identifier get(int intId) {
		return intToId.get(intId);
	}

	public static void register(Identifier id, int intId) {
		idToInt.put(id, intId);
		intToId.put(intId, id);
	}

	public static void bootstrap() {
		BlossomLogger.get().info("Registered Blocks!");
	}

	static {
		// These match the block identifiers of Spore and the int id's of indev.
		register(Identifier.of("stone"), 1);
		register(Identifier.of("grass_block"), 2);
		register(Identifier.of("dirt"), 3);
		register(Identifier.of("cobblestone"), 4);
		register(Identifier.of("planks"), 5);
		register(Identifier.of("sapling"), 6);
		register(Identifier.of("bedrock"), 7);
		register(Identifier.of("water_moving"), 8);
		register(Identifier.of("water_still"), 9);
		register(Identifier.of("lava_moving"), 10);
		register(Identifier.of("lava_still"), 11);
		register(Identifier.of("sand"), 12);
		register(Identifier.of("gravel"), 13);
		register(Identifier.of("gold_ore"), 14);
		register(Identifier.of("iron_ore"), 15);
		register(Identifier.of("coal_ore"), 16);
		register(Identifier.of("wood"), 17);
		register(Identifier.of("leaves"), 18);
		register(Identifier.of("sponge"), 19);
		register(Identifier.of("glass"), 20);
		register(Identifier.of("red_cloth"), 21);
		register(Identifier.of("orange_cloth"), 22);
		register(Identifier.of("yellow_cloth"), 23);
		register(Identifier.of("chartreuse_cloth"), 24);
		register(Identifier.of("green_cloth"), 25);
		register(Identifier.of("spring_green_cloth"), 26);
		register(Identifier.of("cyan_cloth"), 27);
		register(Identifier.of("capri_cloth"), 28);
		register(Identifier.of("ultramarine_cloth"), 29);
		register(Identifier.of("violet_cloth"), 30);
		register(Identifier.of("purple_cloth"), 31);
		register(Identifier.of("magenta_cloth"), 32);
		register(Identifier.of("rose_cloth"), 33);
		register(Identifier.of("dark_gray_cloth"), 34);
		register(Identifier.of("gray_cloth"), 35);
		register(Identifier.of("white_cloth"), 36);
		register(Identifier.of("dandelion"), 37);
		register(Identifier.of("rose"), 38);
		register(Identifier.of("brown_mushroom"), 39);
		register(Identifier.of("red_mushroom"), 40);
		register(Identifier.of("gold_block"), 41);
		register(Identifier.of("steel_block"), 42);
		register(Identifier.of("double_stairs"), 43);
		register(Identifier.of("single_stairs"), 44);
		register(Identifier.of("brick"), 45);
		register(Identifier.of("tnt"), 46);
		register(Identifier.of("book_shelf"), 47);
		register(Identifier.of("mossy_cobblestone"), 48);
		register(Identifier.of("obsidian"), 49);
		register(Identifier.of("torch"), 50);
		register(Identifier.of("fire"), 51);
		register(Identifier.of("water_source"), 52);
		register(Identifier.of("lava_source"), 53);
		register(Identifier.of("crate"), 54);
		register(Identifier.of("cog"), 55);
		register(Identifier.of("diamond_ore"), 56);
		register(Identifier.of("diamond_block"), 57);
		register(Identifier.of("workbench"), 58);
		register(Identifier.of("crops"), 59);
		register(Identifier.of("tilled_dirt"), 60);
		register(Identifier.of("furnace"), 61);
		register(Identifier.of("lit_furnace"), 62);
	}
}
