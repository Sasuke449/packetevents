package io.github.retrooper.packetevents.injector.modern;

import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.event.impl.PacketDecodeEvent;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class PacketDecoderModern extends ByteToMessageDecoder {
    private final PacketEvents packetEvents;


    public PacketDecoderModern(){
        this.packetEvents = PacketEvents.get();
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        PacketDecodeEvent packetDecodeEvent = new PacketDecodeEvent(byteBuf);
        this.packetEvents.getEventManager().callEvent(packetDecodeEvent);

        if(packetDecodeEvent.isCancelled()){
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }

        list.add(byteBuf.readBytes(byteBuf.readableBytes()));
    }
}