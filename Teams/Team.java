package Teams;

import java.util.*;

public abstract class Team {
    private String teamID;
    private String name;
    private Vector<Player> players = new Vector<Player>();

    public Team(String teamID) {
        this.teamID = teamID;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public Enumeration<Player> getAllPlayers() {
        return players.elements();
    }

    public abstract void updatePlayerPosition();

    public abstract void displayTeam();

}
