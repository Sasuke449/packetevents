package io.github.explored.packetevents.utils.nms_entityfinder;

import net.minecraft.server.v1_11_R1.WorldServer;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.entity.Entity;

class EntityFinder_1_11 {
    public static Entity getEntityById(final World world, final int id) {
        WorldServer worldServer = ((CraftWorld) world).getHandle();
        return worldServer.getEntity(id).getBukkitEntity();
    }

}