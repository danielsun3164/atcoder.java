package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6 8\n" + "1 1 2 3 1 2\n" + "1 1\n" + "1 2\n" + "1 3\n" + "1 4\n" + "2 1\n" + "2 2\n" + "2 3\n" + "4 1",
				"1" + LF + "2" + LF + "5" + LF + "-1" + LF + "3" + LF + "6" + LF + "-1" + LF + "-1");
	}

	@Test
	void case2() {
		check("3 2\n" + "0 1000000000 999999999\n" + "1000000000 1\n" + "123456789 1", "2" + LF + "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/C");
	}
}
