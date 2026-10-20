package dev.recruitsfnp.compat;

import com.talhanation.recruits.entities.AbstractRecruitEntity;
import dev.recruitsfnp.RecruitsFlintnpowder;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Every Flint'N'Powder gun kicks the shooter's view with {@code /execute as @p run teleport @p ...}.
 * "@p" is the nearest player and "~ ~ ~" is the shooter's position, so when a recruit fires, that command
 * would teleport the closest player to the recruit. Cancel it whenever the command's source is a recruit.
 * Matchlock-style guns fire from a delayed task, so this cannot depend on being inside a gun step.
 */
@Mod.EventBusSubscriber(modid = RecruitsFlintnpowder.MOD_ID)
public final class RecoilGuard {
    private RecoilGuard() {
    }

    @SubscribeEvent
    public static void onCommand(CommandEvent event) {
        if (event.getParseResults().getContext().getSource().getEntity() instanceof AbstractRecruitEntity
                && event.getParseResults().getReader().getString().contains("teleport @p")) {
            event.setCanceled(true);
        }
    }
}
