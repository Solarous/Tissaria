package net.tissaria;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class TissariaMod implements ModInitializer {
    public static final String MOD_ID = "tissaria";

    // ---- Tissaria Tunnel Sound ----
    // The sound is 14.76 seconds = 295 game ticks. Volume 1.0 = audible up to about 16 blocks.
    public static final Identifier TUNNEL_ID = new Identifier(MOD_ID, "tunnel_sound");
    public static final SoundEvent TUNNEL_SOUND = SoundEvent.of(TUNNEL_ID);
    public static final Block TUNNEL_BLOCK = new TissariaBlock(
            AbstractBlock.Settings.create().strength(1.0f), () -> TUNNEL_SOUND, 295, 1.0f);

    // ---- TISSARIA ----
    // The song is 216.95 seconds = 4338 game ticks. Volume 3.0 = audible up to about 48 blocks.
    public static final Identifier TISSARIA_ID = new Identifier(MOD_ID, "tissaria");
    public static final SoundEvent TISSARIA_SOUND = SoundEvent.of(TISSARIA_ID);
    public static final Block TISSARIA_BLOCK = new TissariaBlock(
            AbstractBlock.Settings.create().strength(1.0f), () -> TISSARIA_SOUND, 4338, 3.0f);

    @Override
    public void onInitialize() {
        Registry.register(Registries.SOUND_EVENT, TUNNEL_ID, TUNNEL_SOUND);
        Registry.register(Registries.SOUND_EVENT, TISSARIA_ID, TISSARIA_SOUND);

        Registry.register(Registries.BLOCK, TUNNEL_ID, TUNNEL_BLOCK);
        Registry.register(Registries.BLOCK, TISSARIA_ID, TISSARIA_BLOCK);

        Item tunnelItem = Registry.register(Registries.ITEM, TUNNEL_ID,
                new BlockItem(TUNNEL_BLOCK, new Item.Settings()));
        Item tissariaItem = Registry.register(Registries.ITEM, TISSARIA_ID,
                new BlockItem(TISSARIA_BLOCK, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(tunnelItem);
            entries.add(tissariaItem);
        });
    }
}
