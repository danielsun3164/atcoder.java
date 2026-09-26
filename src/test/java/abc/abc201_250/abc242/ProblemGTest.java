package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "1 2 3 2 3 1 3 1 2 3\n" + "6\n" + "6 10\n" + "5 8\n" + "3 6\n" + "4 4\n" + "1 6\n" + "1 10",
				"2" + LF + "2" + LF + "1" + LF + "0" + LF + "3" + LF + "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/G");
	}
}
