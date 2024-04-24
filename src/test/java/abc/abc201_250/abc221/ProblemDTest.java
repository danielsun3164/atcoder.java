package abc.abc201_250.abc221;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "2 3\n" + "3 1", "2 2 0");
	}

	@Test
	void case2() {
		check("2\n" + "1000000000 1000000000\n" + "1000000000 1000000000", "0 1000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/D");
	}
}
