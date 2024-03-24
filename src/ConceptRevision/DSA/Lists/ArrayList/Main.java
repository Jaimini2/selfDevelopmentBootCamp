package  src.ConceptRevision.DSA.Lists.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Jaimini","Micro Services"));
        employeeList.add(new Employee(2,"Jay","IOS"));
        employeeList.add(new Employee(3,"Naruto","Swift"));
        employeeList.add(new Employee(4,"Papa","Network Marketing"));

        employeeList.forEach(p -> {
            System.out.println(p);
        });

        System.out.println(employeeList.size());

        System.out.println(employeeList.contains(new Employee(2,"Jay","IOS")));
        System.out.println(employeeList.indexOf(new Employee(4,"Papa","Network Marketing")));
        employeeList.remove(2);

        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.size());


    }
}
