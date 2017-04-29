package cn.mccraft.customitem.item;

import net.minecraft.item.ItemStack;

public class CustomItemHelper {

    public static boolean isCustomItem(ItemStack itemStack){
        if(itemStack==null)
            return false;
        if(!itemStack.hasTagCompound())
            return false;
        return itemStack.getTagCompound().getBoolean("isCustomItem");
    }
}
