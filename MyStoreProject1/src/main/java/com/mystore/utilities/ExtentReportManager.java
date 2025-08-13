package com.mystore.utilities;

	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
        import com.mystore.actionclass.ActionClass;
        import com.mystore.baseclass.BaseClass;



	public class ExtentReportManager  implements ITestListener {
	 
	     ActionClass action= new ActionClass();
	    
		 public ExtentSparkReporter sparkReporter;
		 public static ExtentReports extent;
		 public ExtentTest test;
			
		
		 public void setExtent () {
			 
			 
		 }
		 
			public  void onStart(ITestContext  testContext)
			{
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			  String reportName = "TestReport_" + timestamp + ".html";

	        sparkReporter = new ExtentSparkReporter("./ExtentReport/+ reportName");

	        sparkReporter.config().setDocumentTitle("Automation Test Report");
	        sparkReporter.config().setReportName("MyStore Test Automation");
	        sparkReporter.config().setTheme(Theme.STANDARD);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        // System info
	        extent.setSystemInfo("Tester", "Mannu Nagar");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("OS", "Window11");

	       String browser=  testContext.getCurrentXmlTest().getParameter("browser");
	       extent.setSystemInfo("Browser", browser);
	       
	       List<String> includedGroups= testContext.getCurrentXmlTest().getIncludedGroups();
	       if(!includedGroups.isEmpty()) {
	    	   
	    	   
	    	   extent.setSystemInfo("Groups", includedGroups.toString());
	       }
	    }
			
			public void onTestSuccess(ITestResult result)
			{
				test= extent.createTest(result.getTestClass().getName());
				test.assignCategory(result.getMethod().getGroups());
				test.log(Status.PASS,result.getName()+"got successfully executed");
				
				
			}
			
		
			
             public void onTestFailure(ITestResult result) {
				
				test= extent.createTest(result.getTestClass().getName());
				test.assignCategory(result.getMethod().getGroups());
				test.log(Status.FAIL,result.getName()+"got failed");
				test.log(Status.INFO,result.getThrowable().getMessage());
				
				try {
					
					String imgpath = action.screenShot(BaseClass.getDriver(), result.getName());
					test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());
					
					
				}
				catch(Exception e1) {
					
					e1.printStackTrace();
				}
             }
			
			public void onTestSkipped(ITestResult result) {
				
				test= extent.createTest(result.getTestClass().getName());
				test.assignCategory(result.getMethod().getGroups());
				test.log(Status.SKIP,result.getName()+"Got Skipped");
				test.log(Status.INFO,result.getThrowable().getMessage());
				
			}

			
			public static void endReport() {
				extent.flush();
			
	}

	}
			
			
		