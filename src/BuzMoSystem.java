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


          //initiate friends table/list for user
          createFriendsTable(con);


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

          BuzMoSystem.userEmail = em;

          while(rs.next())
              user = new Person(rs.getString("email"), rs.getString("name"), rs.getString("phone_num"), rs.getString("screen_name"), rs.getString("password"));
          con.close();
      }
      catch(Exception e){System.out.println(e);}
      System.out.println(user.getPhoneNum());
    }

    public void register(String em, String n, String pn, String sn, String pw){
      //search for User in DB
      try{
          Statement st = con.createStatement();

          String sql = "INSERT INTO * FROM mnguyen00.person VALUES('" + em + "', " +
            "'" + n + "', " +
            "'" + pn + "', " +
            sn + ", " +
            "'" + pw + "')";
          System.out.println(sql);
          ResultSet rs = st.executeQuery(sql);

          while(rs.next())
              user = new Person(rs.getString("email"), rs.getString("name"), rs.getString("phone_num"), rs.getString("screen_name"), rs.getString("password"));
          
          //updates registered users
          st.executeUpdate(sql);

          con.close();

          

          
      }
      catch(Exception e){System.out.println(e);}
      System.out.println(user.getPhoneNum());
      


    }

    public void SearchUser(String searchWord){
        //search by email, phonenumber, screenname
        try{
          Statement st = con.createStatement();
          String sql = "SELECT * FROM mnguyen00.person WHERE email = '" + searchWord + 
                    "' OR phone_num = '"+searchWord+ "' OR screen_name = '"+searchWord+"'";
          System.out.println(sql);
          ResultSet rs = st.executeQuery(sql);

          while(rs.next())
              user = new Person(rs.getString("email"), rs.getString("name"), rs.getString("phone_num"), rs.getString("screen_name"), rs.getString("password"));
          con.close();

        }

        catch(Exception e){System.out.println(e);}
        System.out.println(user.getPhoneNum());
          
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
        try{
          Statement st = con.createStatement();
          sql = "CREATE TABLE pendingFriendList " + "(sender VARCHAR(20) NOT NULL, " + " receiver VARCHAR(20) NOT NULL)";
                        st.executeQuery(sql);

                        sql = "CREATE TABLE friendList " + "(owner VARCHAR(20) NOT NULL, " +
                        " friend VARCHAR(20) NOT NULL)";
                        st.executeQuery(sql);

        }
        catch(Exception e){System.out.println(e);}

    }


    public void FriendRequest(String receiver){
        //update in database
        try{
            
            //int flag;
            Statement st = con.createStatement();
            String senderEmail = BuzMoSystem.userEmail;
            
            String sql = "INSERT INTO pendingFriendList " +
            "VALUES ('" + senderEmail + "', " + " '" + receiver + "')";
            st.executeUpdate(sql);
            

            // //check if friend is already pending friend
            // String sql = "SELECT * FROM friendList F WHERE F.friend = '" + f +"'";

            // System.out.println(sql);
            // ResultSet rs = st.executeQuery(sql);

            // while(rs.next()){
            //     flag = rs.getInt(1);
            //     if (flag > 0){
            //       return;
            //     }
            //             

        }

        catch(Exception e){System.out.println(e);}
        System.out.println(user.getPhoneNum());


    }

    public void acceptRequest(Connection c, String acceptedUser){
        try{
            String receiverEmail = BuzmoJFrame.userEmail;
            Statement st = con.createStatement();

            String sql = "DELETE FROM pendingFriendList P " +
            "WHERE P.receiver='" + receiverEmail + "' " + 
            "AND C.sender='" + acceptedUser + "'";
            st.executeUpdate(sql);
            
            // add to contact list both ways
            sql = "INSERT INTO CONTACT_LISTS " + 
            "VALUES ('" + acceptedUser + "', " + 
            " '" + receiverEmail + "')";
            st.executeUpdate(sql);
            
            sql = "INSERT INTO CONTACT_LISTS " + 
            "VALUES ('" + receiverEmail + "', " + 
            " '" + acceptedUser + "')";
            st.executeUpdate(sql);

        }
        catch(Exception e){System.out.println(e);}

    }

    public void managerController(){

    }



    /*
    * Validity Checks
    */

}
