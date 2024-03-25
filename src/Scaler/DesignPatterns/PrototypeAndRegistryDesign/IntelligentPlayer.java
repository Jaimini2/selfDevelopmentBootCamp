package src.Scaler.DesignPatterns.PrototypeAndRegistryDesign;

public class IntelligentPlayer extends Player{

    int iq;

    IntelligentPlayer(){

    }
    IntelligentPlayer(IntelligentPlayer p1){
        super(p1);
        this.iq = p1.iq;
    }

    @Override
    public Player clone(){
        IntelligentPlayer newPlayer = new IntelligentPlayer();
        newPlayer.id = this.id;
        newPlayer.name = this.name;
        newPlayer.rating = this.rating;
        newPlayer.iq = this.iq;

        return newPlayer;
    }

    @Override
    public String toString() {
            return this.id + " , " + this.name + ", " + this.rating + ", " + this.iq;
        }
}
