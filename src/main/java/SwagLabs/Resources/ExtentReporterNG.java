package SwagLabs.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject() {
		// ExtentReports(main class for report), ExtentSparkReporter(helper class to
				// create some configuration)
				String path = System.getProperty("user.dir") + "/reports/index.html"; // path to the file where extent report
																						// get saved
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);// passing the path to ExtentSparkReporter class

				reporter.config().setReportName("Web Automation Results");// set name of report
				reporter.config().setDocumentTitle("Test Results");// set the title

				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);// main class ExtentReports will have knowledge of all the configuration done by
						// ExtentSparkReporter class
				extent.setSystemInfo("Tester", "Aswani Kishore"); // set system info
				return extent;

	}
}
///Users/praveenk/eclipse-workspacenew/Testingproject/test-output/index.html