package DesignPatterns.com.BehavioralDP.Iterator.IteratorChallenge;

import java.util.LinkedList;

public interface IteratorInterface {
    void first(); //Reset to first element
    String next(); //get next element
    boolean isDone(); //End of collection check
    String currentItem(); //Retrieve current item
}

class ArtsIterator implements IteratorInterface{
    private String[] subjects;
    private int position;


    public ArtsIterator(String [] subjects){
        this.subjects = subjects;
        position = 0;
    }

    @Override
    public void first() {
        position = 0;
    }

    @Override
    public String next() {
        return subjects[position++];
    }

    @Override
    public boolean isDone() {
        return position >= subjects.length;
    }

    @Override
    public String currentItem() {
        return subjects[position];
    }
}

class ScienceIterator implements IteratorInterface{
    private LinkedList<String>  subjects;
    private int position;

    public ScienceIterator(LinkedList<String> subjects){
        this.subjects = subjects;
        position = 0;
    }
    @Override
    public void first() {
    position = 0;
    }

    @Override
    public String next() {
        return subjects.get(position++);
    }

    @Override
    public boolean isDone() {
        return position >= subjects.size();
    }

    @Override
    public String currentItem() {
        return subjects.get(position);
    }
}
