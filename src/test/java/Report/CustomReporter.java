package Report;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputDirectory + "/custom-report.html"))) {
            writer.write("<html><head><title>Test Report</title></head><body>");
            writer.write("<h1>Custom TestNG Report</h1>");

            for (ISuite suite : suites) {
                writer.write("<h2>Suite: " + suite.getName() + "</h2>");

                Map<String, ISuiteResult> suiteResults = suite.getResults();

                for (ISuiteResult suiteResult : suiteResults.values()) {
                    ITestContext context = suiteResult.getTestContext();
                    writer.write("<h3>Test: " + context.getName() + "</h3>");
                    writer.write("<table border='1'><tr><th>Test Name</th><th>Status</th><th>Start Time</th><th>End Time</th><th>Duration (ms)</th><th>Screenshot</th></tr>");

                    writeTestResults(writer, context.getPassedTests().getAllResults(), "PASSED");
                    writeTestResults(writer, context.getFailedTests().getAllResults(), "FAILED");
                    writeTestResults(writer, context.getSkippedTests().getAllResults(), "SKIPPED");

                    writer.write("</table>");
                }
            }

            writer.write("</body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeTestResults(BufferedWriter writer, Set<ITestResult> results, String status) throws IOException {
        for (ITestResult result : results) {
            writer.write("<tr>");
            writer.write("<td>" + result.getMethod().getMethodName() + "</td>");
            writer.write("<td>" + status + "</td>");
            writer.write("<td>" + result.getStartMillis() + "</td>");
            writer.write("<td>" + result.getEndMillis() + "</td>");
            writer.write("<td>" + (result.getEndMillis() - result.getStartMillis()) + "</td>");

            String screenshotPath = (String) result.getAttribute("screenshotPath");
            if (screenshotPath != null) {
                writer.write("<td><a href='" + screenshotPath + "'>Screenshot</a></td>");
            } else {
                writer.write("<td></td>");
            }

            writer.write("</tr>");
        }
    }
}

