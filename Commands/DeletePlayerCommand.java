package Commands;

import Teams.*;
import Memento.*;
import java.util.*;

public class DeletePlayerCommand implements Command {
    private Caretaker com;
    private Team team;
    private Player dPlayer;
    private TeamMemento memento;

    public DeletePlayerCommand(Caretaker com) {
        this.com = com;
        this.team = com.currentTeam;
    }

    public boolean execute() {
        Scanner sc = com.sc;
        String input;
        Enumeration<Player> playersEnum = com.currentTeam.getAllPlayers();

        ArrayList<Player> playersList = new ArrayList<>();
        while (playersEnum.hasMoreElements()) {
            playersList.add(playersEnum.nextElement());
        }

        System.out.print("Please input player ID:- ");
        input = sc.nextLine();

        for (int i = 0; i < playersList.size(); i++) {
            Player player = playersList.get(i);
            if (input.equals(player.getPlayerID())) {
                dPlayer = player;
                break;
            }
        }
        if (dPlayer == null) {
            System.out.println("Player not found.");
            return false;
        }

        memento = new TeamMemento(com.currentTeam);
        com.currentTeam.removePlayer(dPlayer);
        System.out.println("Player is deleted.");
        return true;
    }

    public void undo() {
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }

        ArrayList<Player> playersToRemove = new ArrayList<>();
        Enumeration<Player> playersEnum = com.currentTeam.getAllPlayers();
        while (playersEnum.hasMoreElements()) {
            playersToRemove.add(playersEnum.nextElement());
        }

        for (int i = 0; i < playersToRemove.size(); i++) {
            com.currentTeam.removePlayer(playersToRemove.get(i));
        }

        for (int i = 0; i < memento.players.size(); i++) {
            com.currentTeam.addPlayer(memento.players.get(i));
        }
    }

    public void redo() {
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }
        com.currentTeam.removePlayer(dPlayer);
    }

    public String getInfo() {
        return "Delete player, " + dPlayer.getPlayerID();
    }
}
