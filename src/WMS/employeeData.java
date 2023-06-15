/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WMS;

/**
 *
 * @author dangh
 */
public class employeeData {
    
    private String employeeId;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String gmail;
    
    public employeeData(String employeeId,String password, String firstName, String lastName, String gender, String gmail){
    this.employeeId = employeeId;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.gmail = gmail;
    }
    
    public String getEmployeeId(){
        return employeeId;
    }
    public String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getGender(){
        return gender;
    }
    public String getGmail(){
        return gmail;
    }   
    
    public String getPasswordMasked(){
        StringBuilder maskedPassword = new StringBuilder();
        for (int i = 0; i< password.length(); i++){
        maskedPassword.append("*");
        }
        return maskedPassword.toString();
    }
}
