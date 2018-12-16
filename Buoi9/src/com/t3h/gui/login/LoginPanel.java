package com.t3h.gui.login;

import com.t3h.gui.MyButton;
import com.t3h.gui.main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {
    private JLabel lbTitle;
    private JTextField tfUserName;
    private JPasswordField tfPassword;
    private MyButton btnLogin;

    public LoginPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        initComp();
    }

    private void initComp() {
        lbTitle = new JLabel();
        lbTitle.setText("Login");
        lbTitle.setSize(LoginFrame.W, 100);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.RED);
        lbTitle.setFont(new Font(null, Font.BOLD, 20));
        add(lbTitle);
        //============
        tfUserName = new JTextField();
        tfUserName.setSize(LoginFrame.W - 40, 30);
        int y = lbTitle.getY() + lbTitle.getHeight() + 20;
        tfUserName.setLocation(10, y);
        add(tfUserName);
        //============
        tfPassword = new JPasswordField();
        tfPassword.setSize(tfUserName.getWidth(), tfUserName.getHeight());
        y = tfUserName.getY() + tfUserName.getHeight() + 20;
        tfPassword.setLocation(10, y);
        add(tfPassword);
        //=============
        btnLogin = new MyButton("btn_ok_nomal.png", "btn_ok_selected.png");
        btnLogin.setSize(93, 46);
        y = tfPassword.getY() + tfPassword.getHeight() + 20;
        int x = tfPassword.getWidth() + tfPassword.getX() - btnLogin.getWidth();
        btnLogin.setLocation(x, y);
        add(btnLogin);
        btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = tfUserName.getText();
        String password = new String(tfPassword.getPassword());
        if (userName.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null,
                    "Invalid account",
                    "Login Fail",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        MainFrame frame = new MainFrame(userName, password);
        frame.setVisible(true);
        // lấy JFrame đang chứa component hiện tại(JFrame gốc)
        SwingUtilities.getWindowAncestor(btnLogin).dispose();
    }
}
