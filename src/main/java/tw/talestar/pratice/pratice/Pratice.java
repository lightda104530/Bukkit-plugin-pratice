
package tw.talestar.pratice.pratice;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Just try on CraftBukkit plugin.
 *
 * @author lightda104530
 */
 
public class Pratice extends JavaPlugin {
	private final SamplePlayerListener playerListener = new SamplePlayerListener(this);
	private final SampleBlockListener blockListener = new SampleBlockListener();
	private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
	
	@Override
	public void onDisable(){
		//Just like pocketmine!!!Awesome!!
		getLogger().info(Pratice plugin is now Disable!!);
	}
	
	@Override
    public void onEnable() {
		//Uhh...not really like pocketmine anymore lol
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);
        getCommand("pos").setExecutor(new SamplePosCommand());
        getCommand("debug").setExecutor(new SampleDebugCommand(this));
        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }

    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}
	
	
	}