package Test.entity;

/**
 * @author 张烈文
 */
public class Student implements Comparable<Student>{

    private String name;
    private Double score;
    private Integer age;


    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public int compareTo(Student o) {
        if (age > o.getAge()) {
            return 1;
        } else if (age < o.getAge()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }
}
