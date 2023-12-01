package Teams;

import java.util.*;

public class VolleyballTeam extends Team {
    private final int ATTACKER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;

    public VolleyballTeam(String teamID) {
        super(teamID);
    }

    public void updatePlayerPosition() {
        System.out.print("Position (1 = attacker | 2 = defender):- ");
    }

    public void displayTeam() {
        String[] mStrings = { "Attacker:", "Defender:" };
        int[] posistion = { ATTACKER_POSITION, DEFENDER_POSITION };

        HashMap<Integer, Vector<Player>> map = new HashMap<Integer, Vector<Player>>();
        for (int i = 0; i < mStrings.length; i++) {
            map.put(posistion[i], new Vector<Player>());
        }

        Enumeration<Player> players = getAllPlayers();
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            int position = player.getPosition();
            switch (position) {
                case ATTACKER_POSITION:
                case DEFENDER_POSITION:
                    Vector<Player> pVector = map.get(position);
                    pVector.add(player);
                    break;
                default:
                    break;
            }
        }

        System.out.println("Volleyball Team" + getName() + " (" + getTeamID() + ")");
        for (int i = 0; i < mStrings.length; i++) {
            System.out.println(mStrings[i]);
            Vector<Player> pVector = map.get(posistion[i]);
            if (pVector.size() == 0) {
                System.out.println("NIL");
            }
            for (int j = 0; j < pVector.size(); j++) {
                Player player = pVector.get(j);
                System.out.println(player.getPlayerID() + ", " + player.getName());
            }
        }
    }
}
