package Memento;

import Teams.*;

public class PlayerMemento {
    public Player player;

    public PlayerMemento(Player tPlayer) {
        this.player = new Player(tPlayer.getPlayerID(), tPlayer.getName());
        this.player.setPosition(tPlayer.getPosition());
    }

    public Object getPosition() {
        return player.getPosition();
    }

    public String getPlayerID() {
        return player.getPlayerID();
    }

    public String getName() {
        return player.getName();
    }
}
