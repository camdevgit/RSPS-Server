package ab.model.content.zulrah.impl;

import ab.event.CycleEventContainer;
import ab.model.content.zulrah.Zulrah;
import ab.model.content.zulrah.ZulrahLocation;
import ab.model.content.zulrah.ZulrahStage;
import ab.model.players.Player;
import ab.model.players.combat.CombatType;

public class MeleeStageTwo extends ZulrahStage {

	public MeleeStageTwo(Zulrah zulrah, Player player) {
		super(zulrah, player);
	}

	@Override
	public void execute(CycleEventContainer container) {
		if (container.getOwner() == null || zulrah == null || zulrah.getNpc() == null || zulrah.getNpc().isDead
				|| player == null || player.isDead || zulrah.getInstancedZulrah() == null) {
			container.stop();
			return;
		}
		if (zulrah.getNpc().totalAttacks > 1 && zulrah.getNpc().attackTimer == 9 && zulrah.getStage() == 2) {
			player.getZulrahEvent().changeStage(3, CombatType.MAGE, ZulrahLocation.NORTH);
			zulrah.getNpc().totalAttacks = 0;
			zulrah.getNpc().setFacePlayer(true);
			container.stop();
			return;
		}
	}

}