package Memento;

import Teams.*;

import java.util.*;

public class TeamMemento {
    public String teamID;
    public String name;
    public Vector<Player> players = new Vector<Player>();

    public TeamMemento(Team currTeam) {
        this.teamID = currTeam.getTeamID();
        this.name = currTeam.getName();

        // Convert Enumeration to ArrayList
        Enumeration<Player> playersEnum = currTeam.getAllPlayers();
        ArrayList<Player> playersList = Collections.list(playersEnum);

        // Iterate using a normal for loop
        for (int i = 0; i < playersList.size(); i++) {
            Player player = playersList.get(i);
            this.players.add(player);
        }
    }
}
