package com.miningmark48.pearcelmod.network;

import com.google.common.reflect.TypeToken;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ProgressPacket implements IMessage{

    private long pos;

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = buf.readLong();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos);
    }

    public BlockPos getPos(){
        return BlockPos.fromLong(pos);
    }

    @SuppressWarnings("unchecked")
    protected TileEntity getTileEntity(World world){
        if (world == null || !world.isBlockLoaded(getPos())){
            return null;
        }
        TileEntity te = world.getTileEntity(getPos());
        if (te == null){
            return null;
        }

        TypeToken<?> teType = TypeToken.of(getClass()).resolveType(TileEntity.class.getTypeParameters()[0]);
        if (teType.isAssignableFrom(te.getClass())){
            return (TileEntity) te;
        }

        return null;

    }

    public static class Handler implements IMessageHandler<ProgressPacket, IMessage>{

        @Override
        public IMessage onMessage(ProgressPacket message, MessageContext ctx) {
            TileEntity tile = message.getTileEntity(ctx.getServerHandler().playerEntity.world);


            //TODO FINISH LATER

            return null;
        }
    }

}
