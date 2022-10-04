package DesignPatterns.com.BehavioralDP.Memento;

public class FileWriterUtil {
    private String fileName;
    private StringBuilder content;


    FileWriterUtil(String fileName){
        this.content=new StringBuilder();
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return this.content.toString();
    }

    public void write(String str){
        content.append(str);
    }

    //create the Memento
    public Memento save(){
        return  new Memento(fileName,content);
    }

    //restore to its earlier state
    public void undoToLastSave(Object obj){
       Memento memento = (Memento) obj;
        this.fileName = memento.fileName;
        this.content = memento.content;
    }

    private class Memento{
        private String fileName;
        private StringBuilder content;

        public Memento(String fileName,StringBuilder content){
            this.fileName = fileName;
            //doing deep copy over here so that memento and FileWriterUtil
            //content variables don't refer to same object
            this.content = new StringBuilder(content);
        }
    }


}
