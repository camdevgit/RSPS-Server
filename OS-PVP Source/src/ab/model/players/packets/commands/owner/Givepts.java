package ab.model.players.packets.commands.owner;

import java.util.Optional;

import ab.model.players.Player;
import ab.model.players.PlayerHandler;
import ab.model.players.packets.commands.Command;

/**
 * Give 500 store points to a specific user.
 * 
 * @author Emiel
 *
 */
public class Givepts implements Command {

	@Override
	public void execute(Player c, String input) {
		Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayer(input);
		if (optionalPlayer.isPresent()) {
			Player c2 = optionalPlayer.get();
			c2.donatorPoints += 500;
			c.sendMessage("You've given 500 store points to the user:  " + c2.playerName + " IP: " + c2.connectedFrom);
			c2.disconnected = true;
		} else {
			c.sendMessage(input + " is not online. You can only give store points to online players.");
		}
	}
}
