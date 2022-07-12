package abc.abc151_200.abc154;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 6 1 4 5", "YES");
	}

	@Test
	void case2() {
		check("6\n" + "4 1 3 1 6 2", "NO");
	}

	@Test
	void case3() {
		check("2\n" + "10000000 10000000", "NO");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC154/C");
	}
}
