package Commands;

import Teams.*;
import Memento.*;
import java.util.*;

public class ModifyPlayerPositionCommand implements Command {
    private Caretaker com;
    private Team team;
    private String teamType;
    private Player mPlayer;
    private int position;
    private PlayerMemento memento;

    public ModifyPlayerPositionCommand(Caretaker com) {
        this.com = com;
        this.team = com.currentTeam;
        this.teamType = (String) com.teamTypeID.get(com.currentTeam.getTeamID());
    }

    public boolean execute() {
        Scanner sc = com.sc;
        String input;

        // Convert Enumeration to ArrayList
        ArrayList<Player> playersList = Collections.list(com.currentTeam.getAllPlayers());

        System.out.print("Please input player ID:- ");
        input = sc.nextLine();

        // Iterate using a normal for loop
        for (int i = 0; i < playersList.size(); i++) {
            Player player = playersList.get(i);
            if (player.getPlayerID().equals(input)) {
                mPlayer = player;
                break;
            }
        }

        if (mPlayer == null) {
            System.out.println("Player not found");
            return false;
        }

        // Prompt for new player position
        com.currentTeam.updatePlayerPosition();
        input = sc.nextLine();

        try {
            position = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for position. Please enter a number.");
            return false;
        }

        // Save the player's current state
        memento = new PlayerMemento(mPlayer);
        // Set the new position
        mPlayer.setPosition(position);
        System.out.println("Position is updated.");
        return true;
    }

    public void undo() {
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }
        int position = (int) memento.getPosition();
        mPlayer.setPosition(position);
    }

    public void redo() {
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }
        mPlayer.setPosition(position);
    }

    public String getInfo() {
        String playerId = memento.getPlayerID();
        return "Modify player's position, " + playerId + ", "
                + (com.teamPositionInfo.get(teamType)).get(position);
    }
}
