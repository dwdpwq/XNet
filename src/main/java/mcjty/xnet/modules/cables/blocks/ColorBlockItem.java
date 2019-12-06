package mcjty.xnet.modules.cables.blocks;

import mcjty.xnet.XNet;
import mcjty.xnet.modules.cables.CableColor;
import mcjty.xnet.modules.cables.CableSetup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nullable;

public class ColorBlockItem extends BlockItem {

    private final CableColor color;

    public ColorBlockItem(Block blockIn, Properties builder, CableColor color) {
        super(blockIn, builder);
        this.color = color;
    }

    @Nullable
    @Override
    protected BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = ((GenericCableBlock)this.getBlock()).calculateState(context.getWorld(),
                context.getPos(), this.getBlock().getDefaultState().with(GenericCableBlock.COLOR, color));
        if (canPlace(context, blockstate)) {
            return blockstate;
        } else {
            return null;
        }
    }

    @Override
    public String getTranslationKey() {
        // We don't want the translation key of the block
        return super.getDefaultTranslationKey();
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (XNet.setup.getTab().equals(group)) {
            items.add(new ItemStack(CableSetup.NETCABLE_BLUE.get()));
            items.add(new ItemStack(CableSetup.NETCABLE_RED.get()));
            items.add(new ItemStack(CableSetup.NETCABLE_YELLOW.get()));
            items.add(new ItemStack(CableSetup.NETCABLE_GREEN.get()));
            items.add(new ItemStack(CableSetup.NETCABLE_ROUTING.get()));
            items.add(new ItemStack(CableSetup.CONNECTOR_BLUE.get()));
            items.add(new ItemStack(CableSetup.CONNECTOR_RED.get()));
            items.add(new ItemStack(CableSetup.CONNECTOR_YELLOW.get()));
            items.add(new ItemStack(CableSetup.CONNECTOR_GREEN.get()));
            items.add(new ItemStack(CableSetup.CONNECTOR_ROUTING.get()));
            items.add(new ItemStack(CableSetup.ADVANCED_CONNECTOR_BLUE.get()));
            items.add(new ItemStack(CableSetup.ADVANCED_CONNECTOR_RED.get()));
            items.add(new ItemStack(CableSetup.ADVANCED_CONNECTOR_YELLOW.get()));
            items.add(new ItemStack(CableSetup.ADVANCED_CONNECTOR_GREEN.get()));
            items.add(new ItemStack(CableSetup.ADVANCED_CONNECTOR_ROUTING.get()));
        }
    }
}
