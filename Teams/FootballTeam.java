package Teams;

import java.util.*;

public class FootballTeam extends Team {
    private final int GOALKEEPER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;
    private final int MIDFIELDER_POSITION = 3;
    private final int FORWARD_POSITION = 4;

    public FootballTeam(String teamID) {
        super(teamID);
    }

    public void updatePlayerPosition() {
        System.out.print("Position (1 = goal keeper | 2 = defender  | 3 = midfielder | 4 = forward):- ");
    }

    public void displayTeam() {
        String[] mStrings = { "Goal keeper:", "Defender:", "Midfielder:", "Forward:" };
        int[] posistion = { GOALKEEPER_POSITION, DEFENDER_POSITION, MIDFIELDER_POSITION, FORWARD_POSITION };

        HashMap<Integer, Vector<Player>> map = new HashMap<Integer, Vector<Player>>();
        for (int i = 0; i < mStrings.length; i++) {
            map.put(posistion[i], new Vector<Player>());
        }

        Enumeration<Player> players = getAllPlayers();
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            int position = player.getPosition();
            switch (position) {
                case GOALKEEPER_POSITION:
                case DEFENDER_POSITION:
                case MIDFIELDER_POSITION:
                case FORWARD_POSITION:
                    Vector<Player> pVector = map.get(position);
                    pVector.add(player);
                    break;
                default:
                    break;
            }
        }

        System.out.println("Football Team" + getName() + " (" + getTeamID() + ")");
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