import java.util.ArrayList;
import java.util.Iterator;

class  Student implements Iterable<Integer> {
    private ArrayList<Integer> grades  = new ArrayList<>();
    private int index = 0;
    public void addGrade(int grade) {
        if(grade >= 0) {
            grades.add(grade);
        }
    }

    public Double getAverage(){
        double total = 0;
        for (int i=0; i < grades.size(); i++) {
            total +=  grades.get(i);
        }
        return (total / grades.size());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator<Integer>();
    }

    public class MyIterator<Integer> implements Iterator<Integer>
  {

      @Override
      public boolean hasNext() {
          return index < grades.size();
      }

      @Override
      public Integer next() {
          Integer temp = (Integer)  grades.get(index);
            index++ ;
          return temp;
      }
  }
}

class School implements Iterable<Double> {
    private ArrayList<Student> students  = new ArrayList<Student>();
    private int index = 0;
    public void addStudent(Student stud) {
            students.add(stud);
        }

    @Override
    public Iterator<Double> iterator() {
        return new MyIterator<Double>();
    }

    public class MyIterator<Double> implements Iterator<Double>{


        @Override
        public boolean hasNext() {
            return index < students.size();
        }

        @Override
        public Double next() {
            Double temp = (Double) students.get(index).getAverage();
            index++;
            return temp;
        }
    }
}



public class Ex_1 {

    public static void main(String[] args) {

        Student stud = new Student();
        stud.addGrade(90);
        stud.addGrade(100);


        Student stud1 = new Student();
        stud1.addGrade(95);
        stud1.addGrade(97);

        for (int grade : stud) {
            System.out.println(grade);
        }

        for (int grade : stud1) {
            System.out.println(grade);
        }
        School school = new School();
        school.addStudent(stud);
        school.addStudent(stud1);

        for (double avg : school) {
            System.out.println(avg);
        }
    }}