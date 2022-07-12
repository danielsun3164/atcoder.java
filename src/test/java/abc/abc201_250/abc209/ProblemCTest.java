package abc.abc201_250.abc209;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 3", "2");
	}

	@Test
	void case2() {
		check("4\n" + "3 3 4 4", "12");
	}

	@Test
	void case3() {
		check("2\n" + "1 1", "0");
	}

	@Test
	void case4() {
		check("10\n"
				+ "999999917 999999914 999999923 999999985 999999907 999999965 999999914 999999908 999999951 999999979",
				"405924645");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc209/C");
	}
}
