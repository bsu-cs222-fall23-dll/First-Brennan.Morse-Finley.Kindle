package edu.bsu.cs222.wikipedia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Component.BOTTOM_ALIGNMENT;

public class Menu extends JFrame implements ActionListener{
    static JFrame frame;

    public static void main(String[] args){
        String output;
        frame = new JFrame("frame");
        Menu function = new Menu();
        JPanel panel = new JPanel();
        JButton button = new JButton("close");
        button.addActionListener(function);

        User input = new User();
        Redirector redirect = new Redirector();
        ChangeLog changeLog = new ChangeLog();
        ChangeLogFormatter changeLogFormatter = new ChangeLogFormatter();
        RedirectFormatter formatRedirect = new RedirectFormatter();

        output = input.getSearch();

        String format = output;
        redirect.jsonInfo(format);

        String information = changeLogFormatter.changeLogToString(changeLog.jsonInfo(format));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.add(panel);
        panel.add(button);
        frame.setSize(700, 600);
        JLabel text = new JLabel("<html>" + information + "</html>", JLabel.CENTER);
        frame.add(text);
        frame.setVisible(true);
        System.out.println(information);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        String function = click.getActionCommand();
        if (function.equals("close")) {
            frame.setVisible(false);
        }
    }
}
