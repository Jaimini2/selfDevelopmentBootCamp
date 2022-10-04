package DesignPatterns.com.BehavioralDP.Iterator;

interface Iterator {

    //indicates whether there are more elements to the iterator
    boolean hasNext();

    //returns the next element
    Object next();

}
