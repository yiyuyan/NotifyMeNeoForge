package cn.ksmcbrigade.nmn;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.*;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class Utils {

    public static void play(){
        Minecraft client = Minecraft.getInstance();
        SimpleSoundInstance sound = new SimpleSoundInstance(SoundEvents.ITEM_PICKUP.getLocation(), SoundSource.PLAYERS, 0.6f, 0.3f, SoundInstance.createUnseededRandom(), false, 0, SoundInstance.Attenuation.NONE, 0, 0, 0, true);
        client.getSoundManager().play(sound);
    }

    public static class NotifyCommand implements Command<CommandSourceStack> {
        @Override
        public int run(CommandContext<CommandSourceStack> context) {
            NotifyMeNeoForge.notify = !NotifyMeNeoForge.notify;
            context.getSource().sendSystemMessage(Component.literal("Notify: "+NotifyMeNeoForge.notify));
            return 0;
        }
    }
}
