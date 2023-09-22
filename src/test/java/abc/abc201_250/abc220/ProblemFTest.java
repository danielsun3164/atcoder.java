package abc.abc201_250.abc220;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "2 3", "3" + LF + "2" + LF + "3");
	}

	@Test
	void case2() {
		check("2\n" + "1 2", "1" + LF + "1");
	}

	@Test
	void case3() {
		check("6\n" + "1 6\n" + "1 5\n" + "1 3\n" + "1 4\n" + "1 2",
				"5" + LF + "9" + LF + "9" + LF + "9" + LF + "9" + LF + "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/F");
	}
}
