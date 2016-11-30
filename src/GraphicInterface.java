/**
 * Created by Melvine on 11/27/16.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.*;


public class GraphicInterface{
   //login UI
   private String first, second;
   private JTextField loginField;
   private JTextField passField;

   private JButton loginButton;
   private JButton registerButton;

   private JTextField textField1;
   private JTextField textField2;
   private JTextField textField3;
   private JTextField textField4;
   private JTextField textField5;
   private JTextField textField6;

   private JLabel jLabel1;

   private JPanel loginPanel;
   private JPanel registerPanel;

   BuzMoSystem sys = new BuzMoSystem();
   LoginPanel lPanel = new LoginPanel();
   RegisterPanel rPanel = new RegisterPanel();
   UserPanel uPanel = new UserPanel();

   JPanel prevPanel = lPanel;
   CardLayout layout = new CardLayout();
   JPanel cardPanel = new JPanel(layout);


   GraphicInterface(){

      cardPanel.add(lPanel, "login");
      cardPanel.add(rPanel, "register");
      cardPanel.add(uPanel, "userface");

      JFrame frame = new JFrame("BuzMo");
      frame.add(cardPanel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      // RegisterListener registerEvent = new RegisterListener();


  		// passField.addActionListener(loginEvent);
  		// loginButton.addActionListener(loginEvent);
      // registerButton.addActionListener(registerEvent);
   }

   //GENERIC BUTTON LoginListener
   private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if ("Login".equals(command)) {
                layout.show(cardPanel, "login");
            } else if ("Register".equals(command)) {
                layout.show(cardPanel, "register");
            }
        }
    }

   //  //LOGIN - handles Email and Pass
   private class LoginListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            first = loginField.getText();
            second = passField.getText();


            if(sys.login(first, second)){
              layout.show(cardPanel, "userface");
            };
            JOptionPane.showMessageDialog(null, "You are now logged in ");
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
       textField1 = new JTextField("Name", 20);
       textField2 = new JTextField("hi", 20);
       textField3 = new JTextField("hi", 10);
       textField4 = new JTextField("hi", 20);
       textField5 = new JTextField("hi", 10);
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

   class UserPanel extends JPanel{
     UserPanel(){
       add(new JLabel("welcome"));
     }
   }


  private class RegisterListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
        //add(registerPanel);
        JOptionPane.showMessageDialog(null, "You are now registered ");
    }
  }

  //REGISTER - handles Email and Pass
 // private class RegisterHandler implements ActionListener{
 //   public void actionPerformed(ActionEvent event){
 //
 //
 //   }
 // }





















   //private class RegisterInterface implements ActionListener{
    //  private JTextField textField1;
    //  private JTextField textField2;
    //  private JTextField textField3;
    //  private JTextField textField4;
    //  private JTextField textField5;
    //  private JTextField textField6;
     //
    //  @Override
		//  public void actionPerformed(ActionEvent event) {
     //
      //  textField1 = new JTextField("Screen Name (Optional)", 20);
      //  textField2 = new JTextField("Email", 20);
      //  textField3 = new JTextField("Name", 20);
      //  textField4 = new JTextField("Phone Number", 10);
      //  textField5 = new JTextField("Password", 10);
      //  textField6 = new JTextField("Topic Words e.g. CEO Senior Genius", 100);
       //
      //  add(textField1);
      //  add(textField2);
      //  add(textField3);
      //  add(textField4);
      //  add(textField5);
      //  add(textField6);
    //  }
  // }
  //  //handles ID and PIN
  //  private class loginHandler implements ActionListener{
  //      public void actionPerformed(ActionEvent event){
  //          boolean access = false;
  //          if(event.getSource() == loginField || event.getSource() == passField || event.getSource() == buttonField){
  //              first = loginField.getText();
  //              second = passField.getText();
   //
  //              //check user credentials
  //              for(){
  //
  //              }
  //              if(access == false)
  //                  JOptionPane.showMessageDialog(null, "Login failed");
  //          }
  //      }
  //  }
    //buzmo UI - Menubar, OptionButtons

    //Edit UserProfile
    //Search User UI - Send Request
    //FriendList UI
    //MyCircle UI
    //ChatGroup UI
    //Draft message
}
