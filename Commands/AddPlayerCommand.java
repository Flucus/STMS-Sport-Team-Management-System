package Commands;

import Teams.*;
import Memento.*;
import java.util.*;

public class AddPlayerCommand implements Command {
    private Caretaker com;
    private Team team;
    private Player player;
    private String teamType;
    private PlayerMemento memento;

    public AddPlayerCommand(Caretaker com) {
        this.com = com;
        this.team = com.currentTeam;
        this.teamType = com.teamTypeID.get(com.currentTeam.getTeamID()).toString();
    }

    public boolean execute() {
        Scanner scanner = com.sc;
        System.out.print("Please input player information (id, name) :- ");
        String input = scanner.nextLine();
        String[] playerInfo = input.split(",", 2);

        if (playerInfo.length != 2) {
            System.out.println("Invalid input. Ensure format is 'id,name'.");
            return false;
        }

        com.currentTeam.updatePlayerPosition();
        input = scanner.nextLine();
        int position;
        try {
            position = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Position must be a number.");
            return false;
        }

        // Construct a new player object with trimmed id and name from input
        player = new Player(playerInfo[0].trim(), playerInfo[1].trim());
        // Set the player's position
        player.setPosition(position);
        // Save the player state for possible undo
        memento = new PlayerMemento(player);
        // Add player to the current team
        com.currentTeam.addPlayer(player);
        System.out.println("Player is added.");
        return true;
    }

    public void undo() {
        // Check if the current team has changed, if so update the com
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }
        // Remove the player from the team
        com.currentTeam.removePlayer(player);
    }

    public void redo() {
        // Check if the current team has changed, if so update the com
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }
        // Re-add the player to the team
        com.currentTeam.addPlayer(player);
    }

    public String getInfo() {
        // Get the player's position as a string
        String positionInfo = com.teamPositionInfo.get(teamType)
                .get(memento.getPosition()).toString();
        // Return a formatted string with player details
        return "Add player, " + memento.getPlayerID() + ", " + memento.getName() + ", " + positionInfo;
    }
}
