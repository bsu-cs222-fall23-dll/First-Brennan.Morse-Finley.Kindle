package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;

import javax.print.Doc;

public class RedirectFormatter extends Redirector{

    public String redirectFormat(DocumentContext info){
        String count = redirectCountFormat(info);
        String pageName = redirectPageFormat(info);
        return count + pageName;
    }
    public String redirectCountFormat(DocumentContext info){
        int numOfRedirects = redirectCount(info);
        return "Redirected " + numOfRedirects + " times.\n";
    }
    public String redirectPageFormat(DocumentContext info){
        String redirectedPageName = redirectPageName(info);
        return "Redirected to: " + redirectedPageName;
    }

}
