package com.sausedemo.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class OurListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart set status Started");
        result.setStatus(ITestResult.STARTED);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess set status SUCCESS");
        result.setStatus(ITestResult.SUCCESS);
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure set status FAILURE");
        result.setStatus(ITestResult.FAILURE);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped set status Skipped");
        result.setStatus(ITestResult.SKIP);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage set status SUCCESS");
        result.setStatus(ITestResult.SUCCESS);
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout set status failured");
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("onStart" + context.getStartDate());
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish" + context.getEndDate());
    }
}
