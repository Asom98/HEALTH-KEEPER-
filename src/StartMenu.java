import modelS.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JDialog implements ActionListener {

    private JLabel tfname;
    private JButton btnLogin;
    private JButton btnRegistration;
    private JPanel StartMenuPanel;
    private JLabel txInfo;

    public StartMenu(JFrame parent){

        super(parent);
        setTitle("Start Menu");
        setContentPane(StartMenuPanel);
        setMinimumSize(new Dimension(800, 600));
        setModal(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm(null);
            }
        });


        btnRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistrationForm registrationForm = new RegistrationForm(new JFrame());

            }
        });

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(true);
    }

    public static void main(String[] args) {
        StartMenu startMenu = new StartMenu(null);
    }

}

