package RestAPi;


import javax.xml.stream.StreamFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee {
    String name;
    int id;
    long Salary;

    Employee(int id,String name,long salary){
        this.name = name;
        this.id  = id;
        this.Salary = salary;

    }

   /* List<Employee> a1 = new ArrayList<>();

    public List<Employee> getA1() {
        return a1;
    }

    List<Employee> a2 = a1.stream().filter( p -> p.salary > 25k).collect(Collectors.toList());*/


}
