package stdapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDaoImpl implements StudentDaoIntrf {
    Connection con;

    @Override
    public void createStudent(Student std) {
       con =DBConnection.createDBConnetion();
       String query="insert into students values(?,?,?,?,?,?)";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setString(1,std.getName());
           pstm.setString(2,std.getCity());
           pstm.setString(3,std.getCountry());
           pstm.setInt(4,std.getPincode());
           pstm.setDouble(5,std.getSATscore());
           pstm.setString(6,std.getSATscore()>30?"PASS":"FAIL");
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Student Inserted Successfully !!!");


       }catch (Exception ex){
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllStudents() {
        con=DBConnection.createDBConnetion();
        String query="select * from students";
        System.out.println("Student Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\t%s\t%s\n","Name","City","Country","Pincode","SATscore","Passed");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t%s\t%d\t%f\t%s\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getDouble(5),
                        result.getString(6));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showRank(String name) {
        con=DBConnection.createDBConnetion();
        String query="select name,dense_rank() over(order by SATscore desc) as 'Rank' from students";
        //select Score, dense_rank() over(order by Score desc) as 'Rank' from Scores
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            //pstm.setString(1,name);
            ResultSet result= pstm.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\n",
                       result.getString(1),
                        result.getInt(2)
                         );


            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateStudent(String name,double SATscore) {
        con=DBConnection.createDBConnetion();
        String query="update students set SATscore=? where name=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setDouble(1,SATscore);
            pstm.setString(2,name);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Student Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteStudent(String name) {
        con=DBConnection.createDBConnetion();
        String query="delete from students where name=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Student Deleted Successfully!!! "+name);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
