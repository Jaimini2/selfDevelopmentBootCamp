package src.Scaler.DesignPatterns.BuilderDesign;

public class BuilderClient {

    public static void main(String[] args) throws Exception {

       /* StudentBuilder builder  = Student.getBuilder();
        builder.setSubject("Maths");
        builder.setId(1);
        builder.setName("Jaimini");

        Student s1 = builder.build();*/

        Student s2 = Student.getBuilder().setId(1)
                        .setName("Jaimini")
                                .setSubject("Maths")
                                        .build();

        System.out.println(s2.toString());





    }
}
