package utils;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;

/**
 * Contains important methods and variables for the Bot
 */
public class BotUtils {

    /**
     * Private Constructor
     */
    private BotUtils() {

    }

    /**
     * Only messages starting with this prefix will be tracked
     */
    public static final String BOT_PREFIX = "//";

    /**
     * Line comment in config file
     */
    public static final String CONFIG_COMMENT = "#";

    /**
     * Configuration's File Path
     */
    public static final String DEFAULT_CONFIG_PATH =
            System.getProperty("user.dir") + "/config/config.cfg";

    /**
     * Missing Token Error Message
     */
    public static final String MISSING_TOKEN = "RexCord: Please insert your "
            + "server's bot token in the configuration file.";

    /**
     * Config missing Error Message
     */
    public static final String CONFIG_NOT_FOUND_ERROR =
            "RexCord: Config file not found. "
            + "Make sure it is created and located in the correct directory.";

    /**
     * Default Error Message
     */
    public static final String ERROR_MESSAGE =
            "RexCord: Unable to start RexCord!";

    /**
     * RexCord terminating message
     */
    public static final String TERMINATING_MESSAGE =
            "RexCord: Terminating RexCord...";

    /**
     * Bot's user token
     */
    private static String botToken;

    /**
     * Handles the creation of a Bot Client
     * @return A new Bot Client
     */
    public static IDiscordClient createDiscordClient() {
        return new ClientBuilder()
                .withToken(botToken)
                .build();
    }

    /**
     * Sends a text message
     * @param channel text channel
     * @param message message
     */
    public static void sendMessage(IChannel channel, String message) {
        try {
            channel.sendMessage(message);
        } catch (DiscordException de) {
            System.out.println("RexCord: Error sending message. Got error:");
            de.printStackTrace();
        }
    }

    /**
     * Gets Bot Token
     * @return Bot Token
     */
    public static String getBotToken() {
        return botToken;
    }

    /**
     * Sets a new Bot Token
     * @param newToken new Bot Token to be set
     */
    public static void setBotToken(String newToken) {
        BotUtils.botToken = newToken;
    }
}
