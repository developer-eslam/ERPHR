package com.erpproject.enterpriseresourceplanning.erphr.employeereport.project.erp.model;



public class employees {


    private  String F_DateOfStopingSSN;
    private  String F_Passport_Expired_Date;
    private  String F_Status;
    private  String F_Religion;
    private  String F_Nationality;
    private  String F_FirstName;
    private  String F_SecondName;
    private  String F_ThirdName;
    private  String F_FourthName;
    private  String F_PK_SSN;
    private  String F_StreetAndBuilding;

    public  employees(String F_DateOfStopingSSN, String F_StreetAndBuilding){
        setF_DateOfStopingSSN(F_DateOfStopingSSN);
        setF_StreetAndBuilding(F_StreetAndBuilding);
    }

    public  employees(String firstname,String secondname,
                      String thirdname,String fourthname,
                      String F_PK_SSN,String F_StreetAndBuilding
                      ,String F_DateOfStopingSSN,String F_Passport_Expired_Date,
                      String F_Status,String F_Religion,
                      String F_Nationality){
        setF_FirstName(firstname);
        setF_SecondName(secondname);
        setF_ThirdName(thirdname);
        setF_FourthName(fourthname);
        setF_PK_SSN(F_PK_SSN);
        setF_StreetAndBuilding(F_StreetAndBuilding);
        setF_Passport_Expired_Date(F_Passport_Expired_Date);
        setF_Status(F_Status);
        setF_DateOfStopingSSN(F_DateOfStopingSSN);
        setF_Religion(F_Religion);
        setF_Nationality(F_Nationality);
    }
    public  employees(String firstname,String secondname,String thirdname,String fourthname,String F_PK_SSN,String F_StreetAndBuilding ){
        setF_FirstName(firstname);
        setF_SecondName(secondname);
        setF_ThirdName(thirdname);
        setF_FourthName(fourthname);
        setF_PK_SSN(F_PK_SSN);
        setF_StreetAndBuilding(F_StreetAndBuilding);
    }

    public  employees(String firstname,String secondname,String thirdname,String fourthname,String F_PK_SSN){
        setF_FirstName(firstname);
        setF_SecondName(secondname);
        setF_ThirdName(thirdname);
        setF_FourthName(fourthname);
        setF_PK_SSN(F_PK_SSN);
    }
    public String getF_FirstName() {
        return F_FirstName;
    }

    public void setF_FirstName(String f_FirstName) {
        F_FirstName = f_FirstName;
    }

    public String getF_SecondName() {
        return F_SecondName;
    }

    public void setF_SecondName(String f_SecondName) {
        F_SecondName = f_SecondName;
    }

    public String getF_ThirdName() {
        return F_ThirdName;
    }

    public void setF_ThirdName(String f_ThirdName) {
        F_ThirdName = f_ThirdName;
    }

    public String getF_FourthName() {
        return F_FourthName;
    }

    public void setF_FourthName(String f_FourthName) {
        F_FourthName = f_FourthName;
    }

    public String getF_PK_SSN() {
        return F_PK_SSN;
    }

    public void setF_PK_SSN(String f_PK_SSN) {
        F_PK_SSN = f_PK_SSN;
    }

    public String getF_StreetAndBuilding() {
        return F_StreetAndBuilding;
    }

    public void setF_StreetAndBuilding(String f_StreetAndBuilding) {
        F_StreetAndBuilding = f_StreetAndBuilding;
    }

    public String getF_DateOfStopingSSN() {
        return F_DateOfStopingSSN;
    }

    public void setF_DateOfStopingSSN(String f_DateOfStopingSSN) {
        F_DateOfStopingSSN = f_DateOfStopingSSN;
    }

    public String getF_Passport_Expired_Date() {
        return F_Passport_Expired_Date;
    }

    public void setF_Passport_Expired_Date(String f_Passport_Expired_Date) {
        F_Passport_Expired_Date = f_Passport_Expired_Date;
    }

    public String getF_Status() {
        return F_Status;
    }

    public void setF_Status(String f_Status) {
        F_Status = f_Status;
    }

    public String getF_Religion() {
        return F_Religion;
    }

    public void setF_Religion(String f_Religion) {
        F_Religion = f_Religion;
    }

    public String getF_Nationality() {
        return F_Nationality;
    }

    public void setF_Nationality(String f_Nationality) {
        F_Nationality = f_Nationality;
    }
}
