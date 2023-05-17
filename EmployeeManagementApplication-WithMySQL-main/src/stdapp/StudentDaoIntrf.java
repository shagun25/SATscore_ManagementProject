package stdapp;

public interface StudentDaoIntrf {

    //create employee
    public void createStudent(Student emp);
    //show all employee
    public void showAllStudents();
    //show employee based on id
    public void showRank(String name);
    //update employee
    public void updateStudent(String name,double SATscore);
    //delete employee
    public void deleteStudent(String name);
}
