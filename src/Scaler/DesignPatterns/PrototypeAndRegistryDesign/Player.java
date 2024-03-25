package src.Scaler.DesignPatterns.PrototypeAndRegistryDesign;

public class Player implements Prototype<Player>{
    int id;
    String name;
    int rating ;

    Player(){

    }

    Player(Player p){
        this.id = p.id;
        this.name = p.name;
        this.rating = p.rating;
    }

    public Player clone(){
        Player newPlayer = new Player();
        newPlayer.id = this.id;
        newPlayer.name = this.name;
        newPlayer.rating = this.rating;

        return newPlayer;
    }

    @Override
    public String toString() {
        return this.id + " , " + this.name + ", " + this.rating;
    }
}
