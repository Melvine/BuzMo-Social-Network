/**
 * Created by Melvine on 11/27/16.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JOptionPane;


public class GraphicInterface extends JFrame{
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
   BuzMoSystem sys = new BuzMoSystem();


   GraphicInterface(){
      super("Library OS");
      setLayout(new FlowLayout());

      loginField = new JTextField("", 10);
 		  add(loginField);
 	    passField = new JTextField("", 10);
 		  add(passField);
      loginButton = new JButton("Login");
  		add(loginButton);
      registerButton = new JButton("Register");
  		add(registerButton);

      loginHandler loginEvent = new loginHandler();
      RegisterInterface registerEvent = new RegisterInterface();

      loginField.addActionListener(loginEvent);
  		passField.addActionListener(loginEvent);
  		loginButton.addActionListener(loginEvent);
      registerButton.addActionListener(registerEvent);
   }


   //LOGIN - handles Email and Pass
 	private class loginHandler implements ActionListener{
 		public void actionPerformed(ActionEvent event){
        first = loginField.getText();
				second = passField.getText();

        sys.login(first, second);
        JOptionPane.showMessageDialog(null, "You are now logged in ");

    }
  }

  //REGISTER - handles Email and Pass
 private class RegisterInterface implements ActionListener{
   public void actionPerformed(ActionEvent event){
      textField1 = new JTextField("", 20);
      add(loginField);
      textField2 = new JTextField("", 20);
      add(passField);
      textField3 = new JTextField("", 10);
      add(loginField);
      textField4 = new JTextField("", 20);
      add(passField);
      textField5 = new JTextField("", 10);
      registerButton = new JButton("Register");
      add(registerButton);

       sys.login(first, second);
       JOptionPane.showMessageDialog(null, "You are now registered ");

   }
 }





















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
