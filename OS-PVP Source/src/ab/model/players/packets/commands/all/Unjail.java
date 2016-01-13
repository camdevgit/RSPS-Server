package ab.model.players.packets.commands.all;

import ab.model.players.Player;
import ab.model.players.packets.commands.Command;

/**
 * Unjails the player.
 * 
 * @author Emiel
 */
public class Unjail implements Command {

	@Override
	public void execute(Player c, String input) {
		if (c.isInJail()) {
			if (c.jailEnd <= System.currentTimeMillis()) {
				c.teleportToX = 3093;
				c.teleportToY = 3493;
				c.jailEnd = 0;
				c.sendMessage("You've been unjailed. Don't get jailed again!");
			} else {
				long duration = (long) Math.ceil((double) (c.jailEnd - System.currentTimeMillis()) / 1000 / 60);
				c.sendMessage("You need to wait " + duration + " more minutes before you can ::unjail yourself.");
			}
		}
	}
}
