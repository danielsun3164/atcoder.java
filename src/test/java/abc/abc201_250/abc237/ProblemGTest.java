package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("5 2 1\n" + "1 4 5 2 3\n" + "1 3 5\n" + "2 1 3", "3");
	}

	@Test
	void case2() {
		check("7 3 3\n" + "7 5 3 1 2 4 6\n" + "1 1 7\n" + "2 3 6\n" + "2 5 7", "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/G");
	}
}
