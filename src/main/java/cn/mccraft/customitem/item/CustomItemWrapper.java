package cn.mccraft.customitem.item;

import cn.mccraft.customitem.util.ResourceLocation;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import java.util.List;

public class CustomItemWrapper {

    private ItemStack itemStack;
    private List<ResourceLocation> resources = Lists.newArrayList();

    public CustomItemWrapper(ItemStack itemStack){
        setOriginalItemStack(itemStack);
        init();
    }

    private void init(){
        if(!itemStack.hasTagCompound())
            return;

        NBTTagCompound nbtTagCompound = itemStack.getTagCompound();
        if(!nbtTagCompound.getBoolean("isCustomItem"))
            return;

        NBTTagCompound nbtCustomItem = nbtTagCompound.getCompoundTag("CustomItem");

        NBTTagList nbtResources = nbtCustomItem.getTagList("Resources",10);
        for(int i=0,size=nbtResources.tagCount();i<size;i++)
            resources.add(ResourceLocation.getResoureceLocation(nbtResources.getCompoundTagAt(i)));
    }

    public ItemStack getOriginalItemStack(){
        return itemStack;
    }

    public void setOriginalItemStack(ItemStack itemStack){
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack(){
        ItemStack itemStack = this.itemStack.copy();
        itemStack.setTagInfo("isCustomItem",new NBTTagByte((byte)1));

        NBTTagCompound nbtCustomItem = new NBTTagCompound();

        NBTTagList nbtResources = new NBTTagList();
        for(ResourceLocation resource:resources)
            nbtResources.appendTag(resource.toNBT());

        itemStack.setTagInfo("CustomItem",nbtCustomItem);

        return itemStack;
    }
}
