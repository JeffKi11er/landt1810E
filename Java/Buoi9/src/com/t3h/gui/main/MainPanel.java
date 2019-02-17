package com.t3h.gui.main;

import com.t3h.gui.login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    private String userName;
    private String password;
    private JLabel lbTitle;
    private JButton btnLogout;

    public MainPanel(String userName, String password) {
        this.userName = userName;
        this.password = password;
        setLayout(null);
        setBackground(Color.WHITE);
        initComp();
    }

    private void initComp() {
        lbTitle = new JLabel();
        lbTitle.setText("Hi, " + userName + "-" + password);
        lbTitle.setSize(MainFrame.W, 100);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.RED);
        lbTitle.setFont(new Font(null, Font.BOLD, 20));
        add(lbTitle);
        //=============
        btnLogout = new JButton();
        btnLogout.setText("Logout");
        btnLogout.setBackground(Color.BLUE);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setSize(MainFrame.W - 40, 30);
        int y = lbTitle.getY() + lbTitle.getHeight() + 20;
        btnLogout.setLocation(10, y);
        add(btnLogout);
        btnLogout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
