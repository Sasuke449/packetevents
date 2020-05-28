package me.purplex.packetevents.packetwrappers.in.chat;

import me.purplex.packetevents.packetwrappers.api.version.WrappedVersionPacket;
import net.minecraft.server.v1_12_R1.PacketPlayInChat;

class WrappedPacketInChat_1_12 extends WrappedVersionPacket {
    public String message;
    WrappedPacketInChat_1_12(Object packet) {
        super(packet);
    }

    @Override
    protected void setup() {
        PacketPlayInChat p = (PacketPlayInChat)packet;
        this.message = p.a();
    }
}