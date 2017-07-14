package com.miningmark48.pearcelmod.world;

import com.miningmark48.mininglib.utility.WorldUtil;
import com.miningmark48.pearcelmod.handler.ConfigurationHandler;
import com.miningmark48.pearcelmod.reference.Reference;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Map;
import java.util.Random;

public class StructureGenPearcel1 implements IWorldGenerator{

    public static final ResourceLocation STRUCTURE = new ResourceLocation(Reference.MOD_ID, "Pearcel1");
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MOD_ID, "pearcel1_loot");
    public static final ResourceLocation LOOT2 = new ResourceLocation(Reference.MOD_ID, "pearcel1_loot2");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (!(world instanceof WorldServer))
            return;

        if (!ConfigurationHandler.enableStructure1){
            return;
        }

        WorldServer serverworld = (WorldServer) world;

        int x = chunkX * 16 + random.nextInt(16);
        int z = chunkZ * 16 + random.nextInt(16);

        BlockPos xzPos = new BlockPos(x, 1, z);
        Biome biome = world.getBiomeForCoordsBody(xzPos);

        if (biome == Biomes.PLAINS || biome == Biomes.DESERT || biome == Biomes.EXTREME_HILLS || biome == Biomes.BEACH || biome == Biomes.FOREST || biome == Biomes.FOREST_HILLS || biome == Biomes.ICE_PLAINS) {
            if (random.nextInt(ConfigurationHandler.structureRarity2) == 0) { //Rarity
                BlockPos pos = new BlockPos(x, WorldUtil.findEmptySpot(world, x, z), z);
                generateStructure(serverworld, pos, random);
            }
        }

    }

    public static void generateStructure(WorldServer world, BlockPos pos, Random random) {

        MinecraftServer server = world.getMinecraftServer();
        Template template = world.getStructureTemplateManager().getTemplate(server, STRUCTURE);
        PlacementSettings settings = new PlacementSettings();
        settings.setRotation(Rotation.NONE);

        template.addBlocksToWorld(world, pos, settings);

        Map<BlockPos, String> dataBlocks = template.getDataBlocks(pos, settings);
        for (Map.Entry<BlockPos, String> entry : dataBlocks.entrySet()) {
            String[] tokens = entry.getValue().split(" ");
            if (tokens.length == 0)
                return;

            BlockPos dataPos = entry.getKey();

            String s = tokens[0].toLowerCase();
            if (s.equals("lootchest")) {

                String chestOrientation = tokens[1];
                EnumFacing chestFacing = settings.getRotation().rotate(EnumFacing.byName(chestOrientation));
                IBlockState chestState = Blocks.CHEST.getDefaultState().withProperty(BlockChest.FACING, chestFacing);
                world.setBlockState(dataPos, chestState);

                TileEntity tile = world.getTileEntity(dataPos);
                if (tile != null && tile instanceof TileEntityLockableLoot)
                    ((TileEntityLockableLoot) tile).setLootTable(LOOT, random.nextLong());

            }else if (s.equals("lootchest2")) {

                String chestOrientation = tokens[1];
                EnumFacing chestFacing = settings.getRotation().rotate(EnumFacing.byName(chestOrientation));
                IBlockState chestState = Blocks.CHEST.getDefaultState().withProperty(BlockChest.FACING, chestFacing);
                world.setBlockState(dataPos, chestState);

                TileEntity tile = world.getTileEntity(dataPos);
                if (tile != null && tile instanceof TileEntityLockableLoot)
                    ((TileEntityLockableLoot) tile).setLootTable(LOOT2, random.nextLong());

            }

        }

    }


}
