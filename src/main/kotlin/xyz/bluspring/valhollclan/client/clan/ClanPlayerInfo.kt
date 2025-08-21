package xyz.bluspring.valhollclan.client.clan

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.core.UUIDUtil
import java.util.*

data class ClanPlayerInfo(
    val uuid: UUID,
    val name: String,
    val role: ClanRole
) {
    companion object {
        val CODEC = RecordCodecBuilder.create { instance ->
            instance.group(
                UUIDUtil.STRING_CODEC.fieldOf("uuid")
                    .forGetter(ClanPlayerInfo::uuid),
                Codec.STRING.fieldOf("name")
                    .forGetter(ClanPlayerInfo::name),
                ClanRole.CODEC.optionalFieldOf("role", ClanRole.MEMBER)
                    .forGetter(ClanPlayerInfo::role)
            )
                .apply(instance, ::ClanPlayerInfo)
        }
    }
}