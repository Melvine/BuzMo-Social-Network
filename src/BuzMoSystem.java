/**
 * Created by Melvine on 11/27/16.
 */
import javax.swing.JFrame;
import java.sql.* ;

public class BuzMoSystem {
    public static void main(String[] args) {
        System.out.println("hello world");
        //DATABASE CREDENTIALS
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@uml.cs.ucsb.edu:1521:xe";
            String username = "user";
            String password = "pass";

            Connection con= DriverManager.getConnection(url,username, password);
            Statement st = con.createStatement();

            String sql = "SELECT * FROM mnguyen00.abc";
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
                System.out.println(rs.getString("name")); //MODIFY PRINT TO FIT YOUR QUERY AND ATTRIBUTE TYPES
            con.close();
        }
        catch(Exception e){System.out.println(e);}

        //INITIATE USER INTERFACE
        GraphicInterface ui = new GraphicInterface();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setSize(350,100);
        ui.setVisible(true);
    }

    /*
    System Features
    */

    public void Login(){

    }

    public void Register(){

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
