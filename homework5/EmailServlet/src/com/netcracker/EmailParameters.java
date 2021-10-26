package com.netcracker;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailParameters {
    private String toEmail;
    private String copy;
    private String subject;
    private String text;

    public EmailParameters(HttpServletRequest req) {
        this.toEmail = req.getParameter("email");
        this.copy = req.getParameter("copy");
        this.subject = req.getParameter("subject");
        this.text = req.getParameter("text");
    }

    public String getToEmail() {
        return toEmail;
    }

    public String getCopy() {
        return copy;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public boolean validation() {
        boolean res = false;
        String valid = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(valid, Pattern.CASE_INSENSITIVE);
        Matcher matcherEmail = pattern.matcher(toEmail);
        Matcher matcherCopy = pattern.matcher(copy);
        if(matcherEmail.matches()){
            res = true;
        }
        if(matcherCopy.matches() || "".equals(copy)){
            res = true;
        }
        if("".equals(text)) {
            res = false;
        }
        return res;
    }
}
