package cn.ksmcbrigade.nmn;

import net.minecraft.client.Minecraft;
import net.minecraft.commands.Commands;
import net.minecraft.world.entity.vehicle.Minecart;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@Mod(NotifyMeNeoForge.MODID)
@EventBusSubscriber(modid = NotifyMeNeoForge.MODID)
public class NotifyMeNeoForge
{
    public static final String MODID = "nmn";

    public static boolean notify = true;
    public static String playername = Minecraft.getInstance().getUser().getName().toLowerCase();

    public NotifyMeNeoForge(IEventBus modEventBus, ModContainer modContainer)
    {
    }

    @SubscribeEvent
    public static void command(RegisterClientCommandsEvent event){
        event.getDispatcher().register(Commands.literal("notifyme").executes(new Utils.NotifyCommand()));
    }
}
