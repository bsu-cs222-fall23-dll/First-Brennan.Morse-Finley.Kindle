package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.DocumentContext;

public class RedirectFormatter extends Redirector{
    public String redirectFormat(DocumentContext info){
        int numOfRedirects = redirectCount(info);
        return "Redirected " + numOfRedirects + " times.";
    }

}
