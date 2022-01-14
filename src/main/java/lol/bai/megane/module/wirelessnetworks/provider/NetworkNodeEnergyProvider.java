package lol.bai.megane.module.wirelessnetworks.provider;

import lol.bai.megane.api.provider.EnergyProvider;
import me.steven.wirelessnetworks.blockentity.NetworkNodeBlockEntity;
import me.steven.wirelessnetworks.network.Network;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetworkNodeEnergyProvider extends EnergyProvider<NetworkNodeBlockEntity> {

    private Network network;

    @Override
    public void setContext(World world, BlockPos pos, PlayerEntity player, NetworkNodeBlockEntity networkNodeBlockEntity) {
        super.setContext(world, pos, player, networkNodeBlockEntity);

        this.network = networkNodeBlockEntity.getNetwork().orElse(null);
    }

    @Override
    public boolean hasEnergy() {
        return network != null;
    }

    @Override
    public long getStored() {
        return network.getAmount();
    }

    @Override
    public long getMax() {
        return network.getCapacity();
    }

}
