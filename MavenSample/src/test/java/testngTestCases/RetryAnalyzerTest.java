package testngTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzerTest implements IRetryAnalyzer {
	
	int maxRetryCount=3;
	int retryAttemptCounter=0;
	@Override
  public boolean retry(ITestResult result) {
	  if(!result.isSuccess()) {
		  if(retryAttemptCounter < maxRetryCount) {
			  retryAttemptCounter++;
			  return true;
		  }
	  }
	  return false;
  }
}
