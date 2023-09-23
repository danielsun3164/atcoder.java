package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "2 2\n" + "1 3\n" + "2 2", "5" + LF + "3");
	}

	@Test
	void case2() {
		check("5 3\n" + "1 2\n" + "1 4\n" + "2 3", "2");
	}

	@Test
	void case3() {
		check("100 10\n" + "1 31\n" + "2 41\n" + "1 59\n" + "2 26\n" + "1 53\n" + "2 58\n" + "1 97\n" + "2 93\n"
				+ "1 23\n" + "2 84", "69" + LF + "31" + LF + "6" + LF + "38" + LF + "38");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/D");
	}
}
