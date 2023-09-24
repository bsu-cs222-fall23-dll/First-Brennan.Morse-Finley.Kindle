package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.DocumentContext;

import java.io.InputStream;

public class Menu {


    public static void main(String[] args){
        String output;

        User input = new User();
        Redirector redirect = new Redirector();
        ChangeLog changeLog = new ChangeLog();
        ChangeLogFormatter changeLogFormatter = new ChangeLogFormatter();
        RedirectFormatter formatRedirect = new RedirectFormatter();

        output = input.getSearch();

        String format = output;
        redirect.jsonInfo(format);



        System.out.println(changeLogFormatter.changeLogToString(changeLog.jsonInfo(format)));

        System.out.println(changeLog.time(changeLog.jsonInfo(format)));
    }


}
