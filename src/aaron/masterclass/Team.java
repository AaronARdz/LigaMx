package aaron.masterclass;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    //public class Team<T extends Player & manager & coach> //en caso de que queramos agregar diferentes extensiones de un equipo
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;



    private ArrayList<T> members = new ArrayList<T>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println( player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        String message;

        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";

        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public void rankingIndivual() {
        System.out.println(this.name + " Tiene " + (won * 3 + tied) + " Puntos");
        if (won > 1){
            System.out.println(won + " : Partidos Ganados");
        } else{
            System.out.println(won + " : Partido Ganado");
        }
        if (tied > 1){
            System.out.println(tied + " : Partidos Empatados");
        } else{
            System.out.println(tied + " : Partido empatado");
        }

    }
    public int ranking(){
        return (won * 3 + tied);
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()){
            return -1;
        } else if (this.ranking() < team.ranking()){
            return 1;
        } else {
            return 0;
        }
    }
}

