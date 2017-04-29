package cn.mccraft.customitem.util;

import net.minecraft.nbt.NBTTagCompound;

public class ResourceLocation {

    private String localLocation;
    private String remoteLocation;

    public ResourceLocation(String localLocation,String remoteLocation){
        setLocalLocation(localLocation);
        setRemoteLocation(remoteLocation);
    }

    public String getLocalLocation() {
        return localLocation;
    }

    public void setLocalLocation(String localLocation) {
        this.localLocation = localLocation;
    }

    public String getRemoteLocation() {
        return remoteLocation;
    }

    public void setRemoteLocation(String remoteLocation) {
        this.remoteLocation = remoteLocation;
    }

    public NBTTagCompound toNBT(){
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setString("localLocation",getLocalLocation());
        nbtTagCompound.setString("remoteLocation",getRemoteLocation());
        return nbtTagCompound;
    }

    public static ResourceLocation getResoureceLocation(NBTTagCompound nbtTagCompound){
        String localLocation = nbtTagCompound.getString("localLocation");
        String remoteLocation = nbtTagCompound.getString("remoteLocation");
        return new ResourceLocation(localLocation,remoteLocation);
    }

    public static NBTTagCompound toNBT(ResourceLocation resourceLocation){
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setString("localLocation",resourceLocation.getLocalLocation());
        nbtTagCompound.setString("remoteLocation",resourceLocation.getRemoteLocation());
        return nbtTagCompound;
    }
}
