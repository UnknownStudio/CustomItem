package cn.mccraft.customitem;

import cn.mccraft.customitem.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CustomItem.MODID,name = CustomItem.NAME,version = CustomItem.VERSION)
public class CustomItem {
    public static final String MODID = "customitem";
    public static final String NAME = "CustomItem";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide = "cn.mccraft.customitem.client.ClientProxy", serverSide = "cn.mccraft.customitem.common.CommonProxy")
    private static CommonProxy proxy;

    @Mod.Instance(CustomItem.MODID)
    private static CustomItem instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
