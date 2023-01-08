package org.webstar.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports reports = ExtentManager.createReport();

    public static synchronized ExtentTest getTest(){
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest createTest(String testName, String Description){
        ExtentTest test = reports.createTest(testName,Description);
        extentTestMap.put((int) Thread.currentThread().getId(),test);
        return test;

    }
    public static  synchronized void endTest(){
        reports.flush();
    }

}
