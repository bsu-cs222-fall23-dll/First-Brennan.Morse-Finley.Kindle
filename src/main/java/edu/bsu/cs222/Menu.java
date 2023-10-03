package edu.bsu.cs222;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{
    static JFrame frame;
    public static void main(String[] args){
        String output;
        frame = new JFrame("Wikipedia Information");
        Menu function = new Menu();
        JLayeredPane panel = new JLayeredPane();
        JButton button = new JButton("close");
        button.addActionListener(function);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        User input = new User();
        Redirector redirect = new Redirector();
        ChangeLog changeLog = new ChangeLog();
        ChangeLogFormatter changeLogFormatter = new ChangeLogFormatter();
        RedirectFormatter formatRedirect = new RedirectFormatter();

        output = input.getSearch();
        String format = output;
        redirect.jsonInfo(format);

        String information = changeLogFormatter.changeLogToStringHTML(changeLog.jsonInfo(format));
        String redirectInfo = formatRedirect.redirectFormat(changeLog.jsonInfo(format));

        JLabel overallFormatted = new JLabel("<html>" + information + "<br/><br/>" + redirectInfo + "</html>", JLabel.CENTER);

        overallFormatted.setBounds(10, 10, 660, 500);
        button.setBounds(300, 520, 100, 30);
        panel.add(overallFormatted, JLayeredPane.DEFAULT_LAYER);
        panel.add(button, JLayeredPane.PALETTE_LAYER);

        frame.add(panel);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent click) {
        String function = click.getActionCommand();
        if (function.equals("close")) {
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
    }
}