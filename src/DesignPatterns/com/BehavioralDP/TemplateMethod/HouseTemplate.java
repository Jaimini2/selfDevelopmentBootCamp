package DesignPatterns.com.BehavioralDP.TemplateMethod;

public abstract class HouseTemplate {
    //template method , final so subclasses cannot override it
    public  final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built ");
    }

    //default implementation , hook method

    private void buildWindows(){
        System.out.println("building glass windows");
    }

    private void buildFoundation(){
        System.out.println("Building foundation with Cement,iron rods and sand");
    }

    //methods to be implemented by subclasses
    public  abstract void buildWalls();
    public abstract void buildPillars();
}

class WoodenHouse extends HouseTemplate{

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building pillars with Wood Coating");
    }
}

class GlassHouse extends HouseTemplate{

    @Override
    public void buildWalls() {
        System.out.println("Building Glass walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building pillars with Glass Coating");
    }
}
