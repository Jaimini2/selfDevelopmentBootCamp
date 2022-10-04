package DesignPatterns.com.BehavioralDP.Memento;

public class MementoClient {
    public static void main(String[] args) {
        FileWriterCareTaker fileWriterCareTaker = new FileWriterCareTaker();
        FileWriterUtil fileWriterUtil = new FileWriterUtil("data.txt");
        fileWriterUtil.write("The first set of Data : \nMyra \nLucy\n");
        System.out.println(fileWriterUtil + "\n\n");

        //lets save the file
        fileWriterCareTaker.save(fileWriterUtil);

        //now write something else
        fileWriterUtil.write("Second set of data : \nJason \n");

        //checking file contents
        System.out.println(fileWriterUtil + "\n\n");

        //lets undo last save
        fileWriterCareTaker.undo(fileWriterUtil);

        //checking file content again
        System.out.println(fileWriterUtil+"\n\n");
    }
}
