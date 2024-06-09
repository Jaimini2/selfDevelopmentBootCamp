package src.OOPS_Concepts.InterviewQuestions;

public class PolymorphismChildDemo extends PolymorphismDemo {

    @Override
    public void m1(String x) {
        System.out.println("Two");
        super.m1(null);
    }
}
