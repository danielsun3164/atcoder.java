package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答1Test extends TestBase {

	@Test
	void case1() {
		check("8 5\n" + "7 49 30 1 15 8 6 10\n" + "1 2\n" + "2 3\n" + "4 4\n" + "5 8\n" + "3 8",
				"Yes" + LF + "No" + LF + "Yes" + LF + "No" + LF + "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/G");
	}
}
