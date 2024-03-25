package src.Scaler.DesignPatterns.PrototypeAndRegistryDesign;

import src.Scaler.DesignPatterns.BuilderDesign.Student;

public class PrototypeClient {

    public static void main(String[] args) {

        PlayerRegistry str = new PlayerRegistry();

        Player p1 = new Player();
        p1.id = 1;
        p1.name = "Dim";
        p1.rating = 50;

        IntelligentPlayer p2 = new IntelligentPlayer();
        p2.id = 2;
        p2.name = "Jaimini";
        p2.rating = 90;
        p2.iq = 150;


        PlayerRegistry pr = new PlayerRegistry();

        pr.register("normal_player", p1);

        pr.register("Intelligent_player", p2);


        Player p3 = pr.get("Intelligent_player");

        System.out.println(p3);
    }
}
