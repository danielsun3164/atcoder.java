package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答2Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 1048577\n" + "1 1\n" + "2 2097153\n" + "2 3", "1048577" + LF + "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/D");
	}
}
