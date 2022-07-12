package abc.abc201_250.abc212;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 1 4\n" + "2 3", "4");
	}

	@Test
	void case2() {
		check("3 3 3\n" + "1 2\n" + "1 3\n" + "2 3", "0");
	}

	@Test
	void case3() {
		check("5 3 100\n" + "1 2\n" + "4 5\n" + "2 3", "428417047");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc212/E");
	}
}
