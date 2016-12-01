/**
 * Created by Melvine on 11/27/16.
 */
import java.util.*;
import javax.swing.*;
import java.sql.* ;
import java.awt.BorderLayout;

public class BuzMoSystem {
    Person user = new Person();
    Connection con;

    /*
    System Features
    */
    BuzMoSystem(){
      
    }

    public boolean login(String em, String pw){

      //search for User in DB
      try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
          String url = "jdbc:oracle:thin:@uml.cs.ucsb.edu:1521:xe";
          String username = "mnguyen00";
          String password = "782";

          con= DriverManager.getConnection(url,username, password);

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
        System.out.println("welcome " + user.name);
        return true;
      }
      else
        return false;
    }

    public void logout(){
        //update in database
        try{
          user = null;
          con.close();
        }catch(Exception e){System.out.println(e);}
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

    public void parseTopicWordsUser(String user_email, String phrase){
      String[] words = phrase.split(","); //split by commas
      for(int i = 0; i < words.length; i++){
        try{
          Statement st = con.createStatement();
          String sql = "INSERT INTO mnguyen00.TopicWord VALUES(topicword_seq.nextval,'"+ user_email + "', null, '" + words[i] + "')";
          System.out.println(sql);
          ResultSet rs = st.executeQuery(sql);
        }
        catch(Exception e){System.out.println(e);}
      }

    }

    public void parseTopicWordsMsg(String user_email, String mid, String phrase){
      String[] words = phrase.split(","); //split by commas
      for(int i = 0; i < words.length; i++){
        try{
          Statement st = con.createStatement();
          String sql = "INSERT INTO mnguyen00.TopicWord VALUES('" +user_email +
                    "','" +  mid + "', '" + words[i] + "')";
          System.out.println(sql);
          ResultSet rs = st.executeQuery(sql);
        }
        catch(Exception e){System.out.println(e);}
      }

    }

    public ArrayList<String> searchUser(String searchWord){

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

    public void requestFriend(String receiver){
        //update in database
        try{
          Statement st = con.createStatement();
          String sender = user.getEmail();

          String sql = "INSERT INTO mnguyen00.FriendRequest VALUES('" + sender + "'," + "'" + receiver + "'," + "NULL" + ")";
          System.out.println(receiver);




          System.out.println(sql);
          st.executeUpdate(sql);


        }
        catch(Exception e){System.out.println(e);}
    }

    public void addAsNewFriend(String user_email, String friend_email){
      try{
          Statement st = con.createStatement();
          String sql = "INSERT INTO mnguyen00.MyFriends  VALUES ('" + user_email + "' , '" + friend_email + "')";
          System.out.println(sql);

          ResultSet rs = st.executeQuery(sql);

      }
      catch(Exception e){System.out.println(e);}
    }
    public void rmvInFriendRequest(String user_email, String friend_email){
      try{
          Statement st = con.createStatement();
          String sql = "DELETE FROM mnguyen00.FriendRequest WHERE user_email = '" + user_email + "' AND friend_email = '" + friend_email + "'";
          System.out.println(sql);

          ResultSet rs = st.executeQuery(sql);

      }
      catch(Exception e){System.out.println(e);}
    }
    public String listFriendRequests(String sender){
        ArrayList<String> result = new ArrayList<String>(10);
        try{
            Statement st = con.createStatement();
            String sql = "SELECT * FROM mnguyen00.FriendRequest WHERE friend_email = '" + sender + "'";
            System.out.println(sql);

            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                result.add(rs.getString("user_email"));
            }
        }
        catch(Exception e){System.out.println(e);}

        String r_str = "<html>";

        for(int i = 0; i < result.size(); i++){
          r_str += result.get(i) + "<br>";
        }

        r_str += "</html>";

        return r_str;
    }

    public String listMyFriends(String user_email){
        ArrayList<String> result = new ArrayList<String>(10);
        try{
            Statement st = con.createStatement();
            String sql = "SELECT * FROM mnguyen00.MyFriends WHERE user_email = '" + user_email + "'";
            System.out.println(sql);

            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                result.add(rs.getString("friend_email"));
            }

            String sql1 = "SELECT * FROM mnguyen00.MyFriends WHERE friend_email = '" + user_email + "'";
            rs = st.executeQuery(sql1);
            while(rs.next()){
                result.add(rs.getString("user_email"));
            }
        }
        catch(Exception e){System.out.println(e);}

        String r_str = "<html>";

        for(int i = 0; i < result.size(); i++){
          r_str += result.get(i) + "<br>";
        }

        r_str += "</html>";

        return r_str;
    }




}
