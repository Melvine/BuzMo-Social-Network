/**
 * Created by Melvine on 11/27/16.
 */
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.*;


public class GraphicInterface{
   //login UI
   private String input1, input2, input3, input4, input5;
   private JTextField loginField;
   private JTextField passField;

   private JButton loginButton;
   private JButton registerButton;

   private JButton myManagerButton;
   private JButton myCircleButton;
   private JButton myFriendsButton;
   private JButton myGroupsButton;

   private JButton userSearchButton;
   private JButton addFriendButton;
   private JButton friendRequestsButton;
   //private JButton groupRequestsButton;

   private JTextField textField1;
   private JTextField textField2;
   private JTextField textField3;
   private JTextField textField4;
   private JTextField textField5;
   private JTextField textField6;
   private JButton jButton1;
   private JButton jButton2;
   private JButton jButton3;
   private JButton jButton4;
   private JButton jButton5;
   private JButton jButton6;

   private JLabel jLabel1;

   private JPanel loginPanel;
   private JPanel registerPanel;

   JComboBox opList;

   BuzMoSystem sys = new BuzMoSystem();

   LoginPanel lPanel = new LoginPanel();
   RegisterPanel rPanel = new RegisterPanel();
   UserPanel uPanel = new UserPanel();
   MyCirclePanel mcPanel = new MyCirclePanel();
   RequestFriendPanel rfPanel = new RequestFriendPanel();
   UserSearchPanel usPanel = new UserSearchPanel();
   AddFriendPanel afPanel = new AddFriendPanel();

   JPanel prevPanel = lPanel;
   CardLayout layout = new CardLayout();
   JPanel cardPanel = new JPanel(layout);


   GraphicInterface(){

      cardPanel.add(lPanel, "login");
      cardPanel.add(rPanel, "register");
      cardPanel.add(uPanel, "userface");
      cardPanel.add(mcPanel, "mycircle");
      cardPanel.add(rfPanel, "requestfriend");
      cardPanel.add(afPanel, "acceptfriend");
      cardPanel.add(usPanel, "usersearch");


      JFrame frame = new JFrame("BuzMo");
      frame.add(cardPanel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }

   //GENERIC BUTTON LoginListener
   private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("Login".equals(command)) {
                layout.show(cardPanel, "login");
            } else if ("Register".equals(command)) {
                layout.show(cardPanel, "register");
            } else if ("MyCircle".equals(command)) {
                layout.show(cardPanel, "mycircle");
            } else if("Home".equals(command)){
              layout.show(cardPanel,"userface");
            }else if("Search Users".equals(command)){
              layout.show(cardPanel,"usersearch");
            }else if("Request Friends".equals(command)){
              layout.show(cardPanel,"requestfriend");
            }else if("Accept Friends".equals(command)){
              layout.show(cardPanel,"acceptfriend");
            }
        }
    }

   //  //LOGIN - handles Email and Pass
   private class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            input1 = loginField.getText();
            input2 = passField.getText();


            if(sys.login(input1, input2)){
              layout.show(cardPanel, "userface");
            };
            //JOptionPane.showMessageDialog(null, "You are now logged in ");
        }
    }

    private class RegisterListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
          input1 = textField1.getText();
          input2 = textField2.getText();
          input3 = textField3.getText();
          input4 = textField4.getText();
          input5 = textField5.getText();
          sys.register(input1,input2,input3,input4,input5);
          JOptionPane.showMessageDialog(null, "You are now registered ");
      }
    }

    // private class MyCircleListener implements ActionListener{
    //   public void actionPerformed(ActionEvent event){
    //       System.out.println(sys.user.getName());
    //   }
    // }
    private class RequestFriendListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
          input1 = textField2.getText();
          System.out.println(input1 + "test case");
          sys.requestFriend(input1);
          JOptionPane.showMessageDialog(null, "Friend Request Sent");
      }
    }

    private class SendMsgListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
          System.out.println(sys.user.getName());
          System.out.println("Sent Message!");
      }
    }

    private class UserSearchListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
          input1 = textField1.getText();

          ArrayList<String> r = sys.searchUser(input1);
          String r_str = "";

          for(int i = 0; i < r.size(); i++){
            r_str += r.get(i) + "\n";
          }

          JOptionPane.showMessageDialog(null, r_str);
      }
    }

    private class NewFriendListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
          // String userOption = opList.getSelectItem();
          // if(userOption == "accept"){
          //   updateFriendRequestTable(user_email,friend_email,'1');
          // }else{
          //   updateFriendRequestTable(user_email,friend_email,'0');
          // }

          //if right box return 1, if left box return 0
          //if 1, get user email and requester email add to FriendList
          //else
          //if 0 or 1 delete off requestfriend db
          //if 0 or 1 return back to home
      }
    }


   class LoginPanel extends JPanel{
     LoginPanel(){
       loginField = new JTextField("", 10);
       passField = new JTextField("", 10);
       loginButton = new JButton("Login");
       registerButton = new JButton("Register");
       add(loginField);
       add(passField);
       add(loginButton);
       add(registerButton);
       loginField.addActionListener(new LoginListener());
       passField.addActionListener(new LoginListener());
       loginButton.addActionListener(new LoginListener());
       registerButton.addActionListener(new ButtonListener());
     }
   }

   class RegisterPanel extends JPanel{
     RegisterPanel(){
       textField1 = new JTextField("", 20);
       textField2 = new JTextField("", 20);
       textField3 = new JTextField("", 10);
       textField4 = new JTextField("", 20);
       textField5 = new JTextField("", 10);
       registerButton = new JButton("Register Account");
       add(textField1);
       add(textField2);
       add(textField3);
       add(textField4);
       add(textField5);
       add(registerButton);
       registerButton.addActionListener(new RegisterListener());
     }
   }
   class MyCirclePanel extends JPanel{
     MyCirclePanel(){
       //  new JLabel("")
       textField1 = new JTextField("", 20);
       jButton1 = new JButton("Send");
       jButton2 = new JButton("Home");

       add(textField1);
       add(jButton1);
       add(jButton2);
       jButton1.addActionListener(new SendMsgListener());
       jButton2.addActionListener(new ButtonListener());

     }
   }
   class UserSearchPanel extends JPanel{
     UserSearchPanel(){
       textField1 = new JTextField("", 20);
       jButton1 = new JButton("Search");
       jButton2 = new JButton("Home");

       add(textField1);
       add(jButton1);
       add(jButton2);

       jButton1.addActionListener(new UserSearchListener());
       jButton2.addActionListener(new ButtonListener());

     }
   }
   class AddFriendPanel extends JPanel{

     AddFriendPanel(){
       setLayout(new GridLayout(0, 3));
       //getListOfRequesterEmail
       //if right box return 1, if left box return 0
       //if 1, get user email and requester email add to FriendList
       //else
       //if 0 or 1 delete off requestfriend db
       //if 0 or 1 return back to home
      jLabel1 = new JLabel("<html>hi<br>hii<br>hiii</html>");

       String[] options = {"accept", "reject"};
       jButton1 = new JButton("Submit");
       jButton2 = new JButton("Home");

       opList = new JComboBox(options);
       textField1 = new JTextField("", 20);

       add(opList);
       add(textField1);
       add(jButton1);
       add(jButton2);
       add(jLabel1);
       jButton1.addActionListener(new ButtonListener());
       jButton2.addActionListener(new ButtonListener());
     }
   }
  //  class MyFriendsPanel extends JPanel{
  //    MyFriendsPanel(){
  //      //  new JLabel("")
  //      textField1 = new JTextField("", 20);
  //      jButton1 = new JButton("Send");
  //      jButton2 = new JButton("Home");
   //
  //      add(textField1);
  //      add(jButton1);
  //      add(jButton2);
  //      jButton1.addActionListener(new SendMsgListener());
  //      jButton2.addActionListener(new ButtonListener());
   //
  //    }
  //  }
   class RequestFriendPanel extends JPanel{
     RequestFriendPanel(){
       textField2 = new JTextField("", 20);
       jButton1 = new JButton("Request");
       jButton2 = new JButton("Home");

       add(textField2);
       add(jButton1);
       add(jButton2);

       jButton1.addActionListener(new RequestFriendListener());
       jButton2.addActionListener(new ButtonListener());

     }
   }


   class UserPanel extends JPanel{
     UserPanel(){
       myManagerButton = new JButton("ManagerPane");
       myCircleButton = new JButton("MyCircle");
       myFriendsButton = new JButton("MyFriends");
       myGroupsButton = new JButton("MyGroups");

       addFriendButton = new JButton("Accept Friends");
       friendRequestsButton = new JButton("Request Friends");
       //groupRequestsButton = new JButton("Group Requests");
       userSearchButton = new JButton("Search Users");

       add(new JLabel("welcome"));


       add(myManagerButton);
       add(myCircleButton);
       add(myFriendsButton);
       add(myGroupsButton);

       add(addFriendButton);
       add(friendRequestsButton);
       add(userSearchButton);

       userSearchButton.addActionListener(new ButtonListener());
       myCircleButton.addActionListener(new ButtonListener());
       friendRequestsButton.addActionListener(new ButtonListener());
       addFriendButton.addActionListener(new ButtonListener());
     }
   }

    //Edit UserProfile
    //Search User UI - Send Request
    //FriendList UI
    //MyCircle UI
    //ChatGroup UI
    //Draft message
}
