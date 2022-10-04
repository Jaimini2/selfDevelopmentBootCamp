package DesignPatterns.com.BehavioralDP.StateDP.Challenge;

interface  Phone {
    public void ringAlert();
}

class Vibration implements Phone{

    @Override
    public void ringAlert() {
        System.out.println("Phone is on Vibrate Mode .......");
    }
}

class Silent implements Phone{

    @Override
    public void ringAlert() {
        System.out.println("Phone is on Silent Mode ......");
    }
}