package abc.abc201_250.abc232;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 2\n" + "1 3\n" + "1 4\n" + "3 4\n" + "1 3\n" + "1 4\n" + "2 3\n" + "3 4", "Yes");
	}

	@Test
	void case2() {
		check("5 6\n" + "1 2\n" + "1 3\n" + "1 4\n" + "3 4\n" + "3 5\n" + "4 5\n" + "1 2\n" + "1 3\n" + "1 4\n"
				+ "1 5\n" + "3 5\n" + "4 5", "No");
	}

	@Test
	void case3() {
		check("8 0", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc232/C");
	}
}
