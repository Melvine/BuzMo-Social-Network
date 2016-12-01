/**
 * Created by Melvine on 11/27/16.
 */
import java.util.*;
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


        //DEBUG
        //BuzMoSystem sys = new BuzMoSystem();
        //sys.SearchUser("ChrisBrown@gmail.com");

    }

    /*
    System Features
    */
    BuzMoSystem(){
      // user = new Person();

      try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
          String url = "jdbc:oracle:thin:@uml.cs.ucsb.edu:1521:xe";
          String username = "mnguyen00";
          String password = "782";

          con= DriverManager.getConnection(url,username, password);

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
        //search for User in DB
        try{
            Statement st = con.createStatement();

            String sql = "INSERT INTO mnguyen00.person VALUES('" + em + "', " +
              "'" + n + "', " +
              "'" + pn + "', '" +
              sn + "', " +
              "'" + pw + "')";

            System.out.println(sql);
            st.executeUpdate(sql);


        }catch(Exception e){System.out.println(e);}

    }



    public ArrayList searchUser(String searchWord){

        //search by email, phonenumber, screenname
        ArrayList<String> result = new ArrayList<String>();
        //result.add("A");
        try{
          Statement st = con.createStatement();
          String sql = "SELECT * FROM mnguyen00.person WHERE email = '" + searchWord +
                    "' OR phone_num = '"+searchWord+ "' OR screen_name = '"+searchWord+"'";
          System.out.println(sql);
          ResultSet rs = st.executeQuery(sql);

          while(rs.next()){
            result.add(rs.getString("name") + " " + rs.getString("email"));
            System.out.println(rs.getString("name"));
          }
        }
        catch(Exception e){System.out.println(e);}

        return result;
    }

    public void UserSummary(){

    }

    public String getUserName(){
      return user.getName();
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



    public void requestFriend(String receiver){
        //update in database
        try{
          Statement st = con.createStatement();
          String sender = user.getEmail();

          String sql = "INSERT INTO mnguyen00.FriendRequest VALUES('" + sender + "'," + "'" + receiver + "'," + "NULL" + ")";
          System.out.println(receiver);

          // String sql = "INSERT INTO mnguyen00.person VALUES('" + em + "', " +
          //   "'" + n + "', " +
          //   "'" + pn + "', '" +
          //   sn + "', " +
          //   "'" + pw + "')";


          System.out.println(sql);
          st.executeUpdate(sql);


        }
        catch(Exception e){System.out.println(e);}
    }

    public void acceptRequest(Connection c, String acceptedUser){
        // try{
        //     String receiverEmail = BuzmoJFrame.userEmail;
        //     Statement st = con.createStatement();

        //     String sql = "DELETE FROM pendingFriendList P " +
        //     "WHERE P.receiver='" + receiverEmail + "' " +
        //     "AND C.sender='" + acceptedUser + "'";
        //     st.executeUpdate(sql);

        //     // add to contact list both ways
        //     sql = "INSERT INTO CONTACT_LISTS " +
        //     "VALUES ('" + acceptedUser + "', " +
        //     " '" + receiverEmail + "')";
        //     st.executeUpdate(sql);

        //     sql = "INSERT INTO CONTACT_LISTS " +
        //     "VALUES ('" + receiverEmail + "', " +
        //     " '" + acceptedUser + "')";
        //     st.executeUpdate(sql);

        // }
        // catch(Exception e){System.out.println(e);}
    }

    public void managerController(){

    }



    /*
    * Validity Checks
    */

}
