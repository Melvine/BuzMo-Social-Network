/**
 * Created by Melvine on 11/27/16.
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GraphicInterface extends JFrame{
    //login UI
//    private String first,second;
//    private JTextField loginField;
//    private JTextField passField;
//    private JButton buttonField;
//
//    graphicInterface(){
//        super("BuzzMo OS");
//        setLayout(new FlowLayout());
//
//        loginField = new JTextField("ID", 10);
//        add(loginField);
//
//        passField = new JTextField("PIN", 10);
//        add(passField);
//
//        buttonField = new JButton("Login");
//        add(buttonField);
//
//        loginHandler event = new loginHandler();
//        loginField.addActionListener(event);
//        passField.addActionListener(event);
//        buttonField.addActionListener(event);
//    }

    //handles ID and PIN
//    private class loginHandler implements ActionListener{
//        public void actionPerformed(ActionEvent event){
//            boolean access = false;
//            if(event.getSource() == loginField || event.getSource() == passField || event.getSource() == buttonField){
//                first = loginField.getText();
//                second = passField.getText();
//
//                //check user credentials
//                for(User i: data.getUserbase()){
//                    if(i.getId().compareTo(first) == 0 && i.getPin().compareTo(second) == 0){
//                        user = i;
//                        LibrarySystem x = new LibrarySystem();
//                        x.setCurrentUser(user);
//                        x.setCurrentDate(dateField.getText());
//
//                        JOptionPane.showMessageDialog(null, "You are now logged in, " + i.getName());
//                        access = true;
//                        setVisible(false);
//                        graphicInterface test = new graphicInterface(i);
//                        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                        test.setSize(350,100);
//                        test.setVisible(true);
//
//                        break;
//                    }
//                }
//                if(access == false)
//                    JOptionPane.showMessageDialog(null, "Login failed");
//            }
//        }
//    }
    //buzmo UI - Menubar, OptionButtons

    //Edit UserProfile
    //Search User UI - Send Request
    //FriendList UI
    //MyCircle UI
    //ChatGroup UI
    //Draft message
}
