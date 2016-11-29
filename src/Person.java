/**
 * Created by Melvine on 11/27/16.
 */

public class Person {
    String email;
    String name;
    String phone;
    String password;
    String screenname = "";
    String topicwords;


   Person(String e, String n, String pn, String sn, String pw){
       name = n;
       email = e;
       phone = pn;
       password = pw;
       screenname = sn;
    }
//
//    public static void UpdateProfile(){
//
//    }
//
     public String getName(){
       return name;
     }
//
   public String getPhoneNum(){
     return phone;
   }
//
//    public String GetScreenName(){
//
//    }
//
//    public String GetTopicWords(){
//
//    }
//
//    public String GetFriendList(){
//
//    }
}
