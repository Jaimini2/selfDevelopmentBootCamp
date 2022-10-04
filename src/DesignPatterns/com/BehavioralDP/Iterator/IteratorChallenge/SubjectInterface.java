package DesignPatterns.com.BehavioralDP.Iterator.IteratorChallenge;

import java.util.Iterator;
import java.util.LinkedList;

public interface SubjectInterface {
    public IteratorInterface createIterator();
}

class Arts implements SubjectInterface{

    private String[] subjects;

    public Arts(){
        subjects = new String[]{"Bengali","English"};

    }

    @Override
    public IteratorInterface createIterator() {
        return new ArtsIterator(subjects);
    }
}

class Science implements SubjectInterface{
    private LinkedList<String> subjects;

   public  Science(){
        subjects = new LinkedList<String>();
        subjects.addLast("Maths");
        subjects.addLast("Computer Scinece");
        subjects.addLast("Physics");
    }


    @Override
    public IteratorInterface createIterator() {
        return new ScienceIterator(subjects);
    }
}