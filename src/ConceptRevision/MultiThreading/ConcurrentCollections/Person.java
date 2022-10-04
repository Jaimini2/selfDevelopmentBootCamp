package ConceptRevision.MultiThreading.ConcurrentCollections;

public class Person implements Comparable<Person>{
    private int age;
    private String name;

    public Person(int age,String name){
        this.age = age;
        this.name = name;

    }
    @Override
    public int compareTo(Person person) {
       // return this.name.compareTo(person.getName());
        return this.age > person.getAge()? -1 : this.age < person.getAge() ? 1:0;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
