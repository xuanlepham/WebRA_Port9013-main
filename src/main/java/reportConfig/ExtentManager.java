package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.GlobalConstants;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.PROJECT_PATH + "/extentV5/ExtentReport.html");
		reporter.config().setReportName("Admin HTML Report");
		reporter.config().setDocumentTitle("Admin HTML Report");
		reporter.config().setTimelineEnabled(true);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.STANDARD);

		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Company", "IDT");
		extentReports.setSystemInfo("Project", "LHE");
		extentReports.setSystemInfo("Team", "Auto");
		extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
		return extentReports;
	}
}