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

   private JTextField loginField;
   private JTextField passField;

   private JButton loginButton;
   private JButton logoutButton;
   private JButton registerButton;

   private JButton myManagerButton;
   private JButton myCircleButton;
   private JButton myFriendsButton;
   private JButton myGroupsButton;

   private JButton userSearchButton;
   private JButton addFriendButton;
   private JButton friendRequestsButton;
   //private JButton groupRequestsButton;

   private JPanel loginPanel;
   private JPanel registerPanel;



   BuzMoSystem sys = new BuzMoSystem();

   LoginPanel lPanel = new LoginPanel();
   RegisterPanel rPanel = new RegisterPanel();
   UserPanel uPanel = new UserPanel();
   UserSearchPanel usPanel = new UserSearchPanel();
   RequestFriendPanel rfPanel = new RequestFriendPanel();
   AcceptFriendPanel afPanel = new AcceptFriendPanel();
   MyCirclePanel mcPanel = new MyCirclePanel();

   JPanel prevPanel = lPanel;
   CardLayout layout = new CardLayout();
   JPanel cardPanel = new JPanel(layout);


   GraphicInterface(){

      cardPanel.add(lPanel, "login");
      cardPanel.add(rPanel, "register");
      cardPanel.add(uPanel, "userface");
      cardPanel.add(usPanel, "usersearch");
      cardPanel.add(rfPanel, "requestfriend");
      cardPanel.add(afPanel, "acceptfriend");
      cardPanel.add(mcPanel, "mycircle");


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
            }else if("Logout".equals(command)){
              sys.logout();
              layout.show(cardPanel,"login");
               JOptionPane.showMessageDialog(null, "You have logged out");
            }
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
   private class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
             String loginInput = loginField.getText();
             String passInput = passField.getText();


            if(sys.login(loginInput, passInput)){
              layout.show(cardPanel, "userface");
              JOptionPane.showMessageDialog(null, "You are now logged in ");
            }else{
              JOptionPane.showMessageDialog(null, "Wrong Credentials ");
            };
        }
    }




   class RegisterPanel extends JPanel{
     RegisterPanel(){
       setLayout(new GridLayout(0, 1));

       JTextField textField1 = new JTextField("email", 20);
       JTextField textField2 = new JTextField("name", 20);
       JTextField textField3 = new JTextField("phone#", 10);
       JTextField textField4 = new JTextField("screenname", 20);
       JTextField textField5 = new JTextField("password", 10);
       JTextField topicwords = new JTextField("topicwords", 40);
       registerButton = new JButton("Register Account");
       add(textField1);
       add(textField2);
       add(textField3);
       add(textField4);
       add(textField5);
       add(topicwords);
       add(registerButton);

       registerButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent event){
             String input1 = textField1.getText();
             String input2 = textField2.getText();
             String input3 = textField3.getText();
             String input4 = textField4.getText();
             String input5 = textField5.getText();
             String input6 = topicwords.getText();
             sys.register(input1,input2,input3,input4,input5);
             sys.parseTopicWordsUser(input1,input6);
             JOptionPane.showMessageDialog(null, "You are now registered ");
           }
       });

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
       logoutButton = new JButton("Logout");



       add(new JLabel("welcome"));


       add(myManagerButton);
       add(myCircleButton);
       add(myFriendsButton);
       add(myGroupsButton);

       add(addFriendButton);
       add(friendRequestsButton);
       add(userSearchButton);
       add(logoutButton);

       userSearchButton.addActionListener(new ButtonListener());
       myCircleButton.addActionListener(new ButtonListener());
       friendRequestsButton.addActionListener(new ButtonListener());
       addFriendButton.addActionListener(new ButtonListener());
       myFriendsButton.addActionListener(new MyFriendsListener());
       logoutButton.addActionListener(new ButtonListener());
     }
   }

   private class MyFriendsListener implements ActionListener {
     public void actionPerformed(ActionEvent event) {

        JOptionPane.showMessageDialog(null, sys.listMyFriends(sys.user.getEmail()));
     }
   }

   class UserSearchPanel extends JPanel{
     UserSearchPanel(){
       JTextField user_input = new JTextField("", 20);
       JButton jButton1 = new JButton("Search");
       JButton jButton2 = new JButton("Home");

       add(user_input);
       add(jButton1);
       add(jButton2);

       jButton1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event){
             String input1 = user_input.getText();
             System.out.println(sys.user.getEmail());

             ArrayList<String> r = sys.searchUser(input1);
             String r_str = "";

             for(int i = 0; i < r.size(); i++){
               r_str += r.get(i) + "\n";
             }

             r = sys.searchTopic(input1);
             //r_str = "";

             for(int i = 0; i < r.size(); i++){
               r_str += r.get(i) + "\n";
             }



             JOptionPane.showMessageDialog(null, r_str);
         }
       });

       jButton2.addActionListener(new ButtonListener());

     }
   }




   class RequestFriendPanel extends JPanel{
     RequestFriendPanel(){
       JTextField textField = new JTextField("", 20);
       JButton jButton1 = new JButton("Request");
       JButton jButton2 = new JButton("Home");

       add(textField);
       add(jButton1);
       add(jButton2);

       jButton1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event){
             String input1 = textField.getText();

             sys.requestFriend(input1);
             JOptionPane.showMessageDialog(null, "Friend Request Sent");
         }
       });

       jButton2.addActionListener(new ButtonListener());

     }
   }




   class AcceptFriendPanel extends JPanel{

     AcceptFriendPanel(){
       setLayout(new GridLayout(0, 3));
       //getListOfRequesterEmail
       //if right box return 1, if left box return 0
       //if 1, get user email and requester email add to FriendList
       //else
       //if 0 or 1 delete off requestfriend db
       //if 0 or 1 return back to home


       String[] options = {"accept", "decline"};
       JButton jButton1 = new JButton("Submit");
       JButton jButton2 = new JButton("Home");
       JButton jButton3 = new JButton("Show List");

       JComboBox opList = new JComboBox(options);
       JTextField textField = new JTextField("", 20);

       add(opList);
       add(textField);
       add(jButton1);
       add(jButton2);
       add(jButton3);

       jButton1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event){
             String input = textField.getText();
             String option = opList.getSelectedItem().toString();

             if(option == "accept"){
                sys.addAsNewFriend(input, sys.user.getEmail());
                sys.rmvInFriendRequest(input, sys.user.getEmail());
              }
             else if(option == "decline"){
                sys.rmvInFriendRequest(input, sys.user.getEmail());
             }
         }
       });
       jButton2.addActionListener(new ButtonListener());

       jButton3.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event){
             JOptionPane.showMessageDialog(null, sys.listFriendRequests(sys.user.getEmail()));
         }
       });
     }
   }

   class MyCirclePanel extends JPanel{
     MyCirclePanel(){
       setPreferredSize(new Dimension(700, 100));
       JTextArea textArea = new JTextArea();
       JScrollPane scrollPane = new JScrollPane(textArea);
       textArea.setEditable(false);
       JTextField user_input = new JTextField("", 20);
       JButton jButton1 = new JButton("Send");
       JButton jButton2 = new JButton("Home");
       jButton1.setPreferredSize(new Dimension(100, 50));
       jButton2.setPreferredSize(new Dimension(100, 50));

      //  setVerticalGroup(createSequentialGroup()
      //     .addGroup(createParallelGroup(GroupLayout.Alignment.BASELINE)
      //         .addComponent(scrollPane)
      //     .addGroup(createParallelGroup(GroupLayout.Alignment.LEADING))
      //         .addComponent(user_input)
      //         .addComponent(jButton2)
      //         .addComponent(jButton1))
      //  );

       add(scrollPane);
       add(jButton2);

       add(user_input);
       add(jButton1);
       add(jButton2);

       jButton1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent event){
            //  String input1 = user_input.getText();
            //  System.out.println(sys.user.getEmail());
             //
            //  ArrayList<String> r = sys.searchUser(input1);
            //  String r_str = "";
             //
            //  for(int i = 0; i < r.size(); i++){
            //    r_str += r.get(i) + "\n";
            //  }

             //JOptionPane.showMessageDialog(null, r_str);
         }
       });

       jButton2.addActionListener(new ButtonListener());

     }
   }





}
