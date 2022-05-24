package com.dbms.userInterface;

import com.dbms.Utils;
import com.dbms.constants.GlobalConstants;

import java.util.Map;

public class UserView extends UserInterfaceHelper{
    public void showAdminHomePage(){
        System.out.println("1. Add user");
        System.out.println("2. Execute Query");
        System.out.println("3. Generate Dump");
        System.out.println("4. Generate ERD");
        System.out.println("5. Logout");
    }

    public void showUserHomePage(){
        System.out.println("1. Execute Query");
        System.out.println("2. Generate Dump");
        System.out.println("3. Generate ERD");
        System.out.println("4. Logout");
    }

    public void query() {
        System.out.print("Enter the query: ");
    }

    public Map<String, Object> addNewCustomer(Map<String, Object> userDetails){

        System.out.println("Please Enter Details: ");
        for(Map.Entry<String, Object> item : userDetails.entrySet()){
            System.out.println("Enter "+item.getKey()+" *");
            if(item.getKey().contains(GlobalConstants.USERNAME)){
                item.setValue(getValidEmailInput());
            } else if(item.getKey().contains(GlobalConstants.PASSWORD)){
                item.setValue(Utils.encryptToSha256(getStringInputNoValidation()));
            }else {
                item.setValue(getLine());
            }
        }
        return userDetails;
    }

    public void enterQuery() {
        System.out.println("Enter the query (0 to go back): ");
    }

    public void selectDatabase(){
        System.out.println("Select a database (example USE school):");
    }

    public void selectDbToDump() {
        System.out.println("Enter the database name to generate dump: ");
    }

    public void selectDbToErd() {
        System.out.println("Enter the database name to generate ERD for: ");
    }

    public void erdGenerated() {
        System.out.println("ERD has been generated");
    }
    public void dumpCreated() {
        System.out.println("Dump has been generated successfully! ");
    }

    public void dumpFailed() {
        System.out.println("Dump has been generation failed! ");
    }
}
