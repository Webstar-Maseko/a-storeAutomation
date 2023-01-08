package org.webstar.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static final ExtentReports report = new ExtentReports();

    public synchronized static ExtentReports createReport(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Results/ExtentResults.html");
        sparkReporter.config().setReportName("Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);
        report.attachReporter(sparkReporter);
        report.setSystemInfo("Author","Webstar Maseko");
        return  report;
    }
}
