package com.fish.base;

//package base;
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
public class Mail {
//    public static void main(String[] args) {
//        ActiveXComponent axOutlook = new ActiveXComponent("Outlook.Application");
//        Dispatch mailItem = Dispatch.call(axOutlook, "CreateItem", 0).getDispatch();
//        Dispatch inspector = Dispatch.get(mailItem, "GetInspector").getDispatch();
//        Dispatch recipients = Dispatch.call(mailItem, "Recipients").getDispatch();
//        Dispatch.call(recipients, "Add" , "chouyuinwater@163.com");
//        Dispatch.put(mailItem, "Subject", "Test5!");
////        Dispatch.put(mailItem, "CC", "1@qq.com");
//        String body = "<html><body><div style='color:red;'>This is a Test !</div></body></html>";
//        String html = "";
////        try {
////            BufferedReader bf = new BufferedReader(new FileReader(new File("F:/Ro.htm")));
////            String str = "";
////            while( (str=bf.readLine()) != null){
////                html += str;
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        Dispatch.put(mailItem, "HTMLBody", body);
//        Dispatch.call(mailItem, "Display");
//        Dispatch.call(mailItem, "Send");
//    }
}
