/**
 * Created by Melvine on 11/27/16.
 */
import javax.swing.*;
import java.sql.* ;
import java.awt.BorderLayout;

public class BuzMoSystem {
    Person user;
    Connection con;

    public static void main(String[] args) {
        //DATABASE CREDENTIALS
        // try{
        //     Class.forName("oracle.jdbc.driver.OracleDriver");
        //     String url = "jdbc:oracle:thin:@uml.cs.ucsb.edu:1521:xe";
        //     String username = "mnguyen00";
        //     String password = "782";
        //
        //     Connection con= DriverManager.getConnection(url,username, password);
        //     Statement st = con.createStatement();
        //
        //     String sql = "SELECT * FROM mnguyen00.abc";
        //     ResultSet rs = st.executeQuery(sql);
        //
        //     while(rs.next())
        //         System.out.println(rs.getString("name")); //MODIFY PRINT TO FIT YOUR QUERY AND ATTRIBUTE TYPES
        //     con.close();
        // }
        // catch(Exception e){System.out.println(e);}

        //INITIATE USER INTERFACE
        GraphicInterface test = new GraphicInterface();
    }
    /*
    System Features
    */
    BuzMoSystem(){
      try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
          String url = "jdbc:oracle:thin:@uml.cs.ucsb.edu:1521:xe";
          String username = "mnguyen00";
          String password = "782";

          con= DriverManager.getConnection(url,username, password);


          //initiate friends table/list for user
          createFriendsTable(con);


        }
        catch(Exception e){System.out.println(e);}
    }

    public boolean login(String em, String pw){

      //search for User in DB
      try{
          Statement st = con.createStatement();

          String sql = "SELECT * FROM mnguyen00.person WHERE email= '" + em + "' AND password='" + pw + "'";
          System.out.println(sql);
          ResultSet rs = st.executeQuery(sql);

          while(rs.next())
              user = new Person(rs.getString("email"), rs.getString("name"), rs.getString("phone_num"), rs.getString("screen_name"), rs.getString("password"));
          con.close();
      }
      catch(Exception e){System.out.println(e);}
      System.out.println(user.getPhoneNum());

      if(user != null){
        System.out.println("true");
        return true;
      }
      else
        return false;
    }

    public void register(String em, String n, String pn, String sn, String pw){

    }

    public void SearchUser(String searchWord){

    }

    public void UserSummary(){

    }

    public void PostMessage(){

    }

    public void DeleteMessage(){

    }

    public void CreateChatGroup(){

    }

    public void DeleteChatGroup(){

    }

    public void ChatGroupController(){
        //edit chatname
        //invite to group
        //accept to chatgroup



    }

    public static void createFriendsTable(Connection c){

    }

    public void acceptRequest(Connection c, String acceptedUser){
        
    }

    public void managerController(){

    }



    /*
    * Validity Checks
    */

}
