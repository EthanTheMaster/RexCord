package commands;

import main.RexCord;

import sx.blah.discord.handle.impl.events.guild.channel.message
        .MessageReceivedEvent;
import utils.MathHandler;

/**
 * Calculates a certain expression that the user typed
 */
public class MathCommand implements BotCommand {

    /**
     * Main instance of RexCord
     */
    private RexCord rexCord;

    /**
     * Represents the command name
     */
    private static final String COMMAND_NAME = "math";

    /**
     * Represents the command description
     */
    private static final String COMMAND_DESCRIPTION
            = "Calculates a given mathematical operation";

    /**
     * A message header!
     */
    private static final String MESSAGE_HEADER =
            "That looks easy! :nerd: \n";

    /**
     * Creates an instance of Math Command class
     * @param rexCord main instance of rexCord
     */
    public MathCommand(RexCord rexCord) {
        this.rexCord = rexCord;
    }

    /**
     * Gets command name
     *
     * @return A String with the Command name
     */
    @Override
    public final String getCommandName() {
        return COMMAND_NAME;
    }

    /**
     * Gets Command description
     * @return command description
     */
    @Override
    public final String getCommandDescription() {
        return COMMAND_DESCRIPTION;
    }

    /**
     * Runs the command triggered by the user
     *
     * @param event the event triggered by the user
     */
    @Override
    public final void runCommand(MessageReceivedEvent event, String args) {
        // FIXME due to args being a vector,
        // it is only selecting the first argument
        rexCord.sendMessage(event.getChannel(),
                MESSAGE_HEADER
                        + MathHandler.handleOperation(args));
    }

}
