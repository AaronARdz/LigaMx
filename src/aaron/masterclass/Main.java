package aaron.masterclass;

public class Main {

    public static void main(String[] args) {
        FootballPlayer mahomes = new FootballPlayer("Mahomes");
        BaseballPlayer tomatero = new BaseballPlayer("Tomatero");
        SoccerPlayer gignac = new SoccerPlayer("Gignac");
        SoccerPlayer funesmori = new SoccerPlayer("Funes Mori");
        SoccerPlayer darwin = new SoccerPlayer("Darwin, El cientifico del gol");
        SoccerPlayer jjMacias = new SoccerPlayer("JJ Macias");

        Team<FootballPlayer> kansas = new Team<>("Kansas");
        kansas.addPlayer(mahomes);
        //kansas.addPlayer(tomatero); not football player,

        Team<BaseballPlayer> tomateros = new Team<>("Tomateros de Sinaloa");
        tomateros.addPlayer(tomatero);

        Team<SoccerPlayer> tigres = new Team<>("Tigres UANL");
        tigres.addPlayer(gignac);

        Team<SoccerPlayer> rayados = new Team<>("Rayados");
        rayados.addPlayer(funesmori);

        Team<SoccerPlayer> america = new Team<>("America");
        america.addPlayer(darwin);

        Team<SoccerPlayer> chivas = new Team<>("Chivas rayadas del guadalajara");
        chivas.addPlayer(jjMacias);

        tigres.matchResult(rayados,6,2);
        rayados.matchResult(america,2,1);
        america.matchResult(chivas,3,2);
        tigres.matchResult(america,3,0);
        chivas.matchResult(rayados,5,3);
        tigres.matchResult(chivas,4,1);
        tigres.matchResult(rayados,1,1);
        rayados.matchResult(america,2,2);

        System.out.println("Rankings: ");
        tigres.rankingIndivual();
        rayados.rankingIndivual();
        chivas.rankingIndivual();

        System.out.println(tigres.compareTo(rayados));

        League<Team<SoccerPlayer>> ligamx = new League<>("Liga Mx");
        ligamx.add(tigres);
        ligamx.add(rayados);
        ligamx.add(chivas);
        ligamx.add(america);
        ligamx.showLeagueTable();



    }
}