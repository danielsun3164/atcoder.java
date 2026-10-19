package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 4\n" + "9 8 3 7 2\n" + "1 6 2 9 5", "Yes");
	}

	@Test
	void case2() {
		check("4 90\n" + "1 1 1 100\n" + "1 2 3 100", "No");
	}

	@Test
	void case3() {
		check("4 1000000000\n" + "1 1 1000000000 1000000000\n" + "1 1000000000 1 1000000000", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/C");
	}
}
