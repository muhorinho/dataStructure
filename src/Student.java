import java.util.stream.IntStream;

public class Student<T> implements Comparable<Student> {

    int id;
    String name;
    int mathGrade;
    int dsGrade;
    double average;
    public double getAverage() {
        return average;
    }
    //String state;

    public Student(int id,String name,int mathGrade,int dsGrade) {
        this.id = id;
        this.name = name;
        this.mathGrade = mathGrade;
        this.dsGrade = dsGrade;
        average = (mathGrade+dsGrade)/2;
    }
    public int getId() {
        return id;
    }
    public int getMathGrade() {
        return mathGrade;
    }
    public int getDsGrade() {
        return dsGrade;
    }



    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    static String compare = "";
    public static void setCompare(String compare) {
        Student.compare = compare;
    }
    @Override
    public int compareTo(Student o) {
        return switch (compare) {
            case "Overall average" -> Double.compare(this.getAverage(), o.getAverage());
            case "Data Structures" -> Integer.compare(this.getDsGrade(), o.getDsGrade());
            default -> 0;
        };
    }
    public static Student findTheStudent(LinkedList<Student> students, int id) {
        return IntStream.range(0, students.size()).mapToObj(students::peek).filter(student -> student.getId() == id).findFirst().orElse(null);
    }
    public static int mathAverage(LinkedList<Student> students, String lesson) {
        switch (lesson) {
            case "math average" -> {
                int total = 0;
                int i = 0;
                while (i < students.size()) {
                    Student student = students.peek(i);
                    total += student.getMathGrade();
                    i++;
                }
                return total / students.size();
            }
        }
        return 0;
    }
    public static LinkedList<Student> lowestDataGrade(LinkedList<Student> students, String dataStructures) {
        if ("lowest data structures".equals(dataStructures)) {
            LinkedList<Student> lowestData = new LinkedList<>();
            double dsGrade = students.peek(0).getDsGrade();
            int i = 0;
            while (i < students.size()) {
                Student student = students.peek(i);
                if (student.getDsGrade() < dsGrade) {
                    lowestData.clear();
                    lowestData.insert(student);
                    dsGrade = student.getDsGrade();
                }
                if (student.getDsGrade() == dsGrade) {
                    lowestData.insert(student);
                }
                i++;
            }
            return lowestData;
        }
        return students;
    }
 @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                ", dataStructuresGrade=" + dsGrade;
    }
}