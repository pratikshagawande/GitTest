package MME.meeplatform.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count = 0;
	int MaxTry = 1;

	@Override
	public boolean retry(ITestResult arg0) {

		if (count < MaxTry) {
			count++;
			return true;
		}
		return false;
	}

}
