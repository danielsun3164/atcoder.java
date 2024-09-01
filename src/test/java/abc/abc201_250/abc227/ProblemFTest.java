package abc.abc201_250.abc227;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("1 3 2\n" + "3 4 5", "9");
	}

	@Test
	void case2() {
		check("2 2 1\n" + "3 2\n" + "4 3", "3");
	}

	@Test
	void case3() {
		check("3 5 3\n" + "4 7 8 6 4\n" + "6 7 3 10 2\n" + "3 8 1 10 4", "21");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/F");
	}
}
