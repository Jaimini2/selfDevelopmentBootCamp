package src.Scaler.DesignPatterns.BuilderDesign;

public class Student {
    int id;
    String name;
    String subject;

   public Student(StudentBuilder builder){
        this.id = builder.getId();
        this.name = builder.getName();
        this.subject = builder.getSubject();
    }

    @Override
    public String toString() {
        return "id = " + this.id +" Name = "+ this.name + " Subject = "+ this.subject;
    }

    public static StudentBuilder getBuilder(){
        return  new StudentBuilder();
    }

    static class StudentBuilder{
        int id;
        String name;
        String subject;

        public String getName() {
        return name;
    }

        public int getId() {
        return id;
    }

        public String getSubject() {
        return subject;
    }

        public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

        public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

        public StudentBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

        public Student build() throws Exception {
        //add validations over here

        if(this.id < 0){
            throw new Exception("Invalid Id");
        }
        return new Student(this);
    }
    }

}
