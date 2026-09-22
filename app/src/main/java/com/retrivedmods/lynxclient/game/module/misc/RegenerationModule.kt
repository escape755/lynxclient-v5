package com.retrivedmods.lynxclient.game.module.misc

import com.retrivedmods.lynxclient.game.InterceptablePacket
import com.retrivedmods.lynxclient.game.Module
import com.retrivedmods.lynxclient.game.ModuleCategory
import com.retrivedmods.lynxclient.game.data.Effect
import org.cloudburstmc.protocol.bedrock.packet.MobEffectPacket
import org.cloudburstmc.protocol.bedrock.packet.PlayerAuthInputPacket

class RegenerationModule : Module("Regeneration", ModuleCategory.Misc) {

    override fun onDisabled() {
        super.onDisabled()
        if (isSessionCreated) {
            session.clientBound(MobEffectPacket().apply {
                runtimeEntityId = session.localPlayer.runtimeEntityId
                event = MobEffectPacket.Event.REMOVE
                effectId = Effect.REGENERATION
            })
        }
    }

    override fun beforePacketBound(interceptablePacket: InterceptablePacket) {
        if (!isEnabled) {
            return
        }

        val packet = interceptablePacket.packet
        if (packet is PlayerAuthInputPacket) {
            if (session.localPlayer.tickExists % 20 == 0L) {
                session.clientBound(MobEffectPacket().apply {
                    runtimeEntityId = session.localPlayer.runtimeEntityId
                    event = MobEffectPacket.Event.ADD
                    effectId = Effect.REGENERATION
                    amplifier -= 1
                    isParticles = false
                    duration = 360000
                })
            }
        }
    }

}