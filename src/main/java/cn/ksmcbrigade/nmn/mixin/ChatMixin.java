package cn.ksmcbrigade.nmn.mixin;

import cn.ksmcbrigade.nmn.NotifyMeNeoForge;
import cn.ksmcbrigade.nmn.Utils;
import com.mojang.authlib.GameProfile;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.PlayerChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.multiplayer.chat.ChatListener.class)
public class ChatMixin {
    @Inject(method = "handlePlayerChatMessage",at = @At("TAIL"))
    public void chat(PlayerChatMessage p_251553_, GameProfile p_250022_, ChatType.Bound p_252158_, CallbackInfo ci){
        if(!NotifyMeNeoForge.notify) return;
        String message = p_251553_.signedContent().toLowerCase();
        if(message.contains(NotifyMeNeoForge.playername)){
            Utils.play();
        }
    }
}
