package org.amm.pc.utils;

import java.net.*;
import java.io.*;

public class URLConnectionAuthReader {
    public static void main(String[] args) throws Exception {
    	
        String username = "username";
        String password = "password";
        URL authurl = new URL("http://www.protectedurl.com/");

        Authenticator.setDefault(new MyAuthenticator(username, password));
        URLConnection ac = authurl.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                ac.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }

    protected static class MyAuthenticator extends Authenticator {
        private String username, password;

        public MyAuthenticator(String user, String pwd) {
            username = user;
            password = pwd;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password.toCharArray());
        }
    }
}