package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "2 3\n" + "2 2", "Yes");
	}

	@Test
	void case2() {
		check("4 3\n" + "1 3\n" + "1 2\n" + "2 3", "No");
	}

	@Test
	void case3() {
		check("4 4\n" + "1 1\n" + "2 2\n" + "3 3\n" + "1 4", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/E");
	}
}
