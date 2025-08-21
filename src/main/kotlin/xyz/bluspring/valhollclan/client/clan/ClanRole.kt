package xyz.bluspring.valhollclan.client.clan

import net.minecraft.util.StringRepresentable

enum class ClanRole(val iconChar: Char, private val serialized: String) : StringRepresentable {
    // Targets
    TARGET_KOS('\ue001', "target_kos"), TARGET('\ue002', "target"),

    // Ally
    ALLY('\ue003', "ally"),

    // Members
    MEMBER('\ue004', "member"), RECRUITER('\ue005', "recruiter"), OFFICER('\ue006', "officer"), COLEADER('\ue007', "coleader"), LEADER('\ue008', "leader"), FOUNDER('\ue009', "founder");

    override fun getSerializedName(): String {
        return this.serialized
    }

    val isTarget: Boolean
        get() = this == TARGET_KOS || this == TARGET

    companion object {
        val CODEC = StringRepresentable.fromEnum(ClanRole::values)
    }
}