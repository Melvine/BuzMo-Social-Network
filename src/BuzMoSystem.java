/**
 * Created by Melvine on 11/27/16.
 */
import javax.swing.JFrame;
import java.sql.* ;

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
    		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		test.setSize(350,100);
    		test.setVisible(true);
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
        }
        catch(Exception e){System.out.println(e);}
    }

    public void login(String em, String pw){

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
    }

    public void register(){
      //search for User in DB
      try{
          Statement st = con.createStatement();

          String sql = "INSERT INTO * FROM mnguyen00.person VALUES()";
          System.out.println(sql);
          ResultSet rs = st.executeQuery(sql);

          con.close();
      }
      catch(Exception e){System.out.println(e);}
    }

    public void SearchUser(){

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

    public void FriendRequest(){
        //update in database
    }

    public void managerController(){

    }

    /*
    * Validity Checks
    */

}
