package abc.abc051_100.abc077;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 5\n" + "2 4\n" + "3 6", "3");
	}

	@Test
	void case2() {
		check("3\n" + "1 1 1\n" + "2 2 2\n" + "3 3 3", "27");
	}

	@Test
	void case3() {
		check("6\n" + "3 14 159 2 6 53\n" + "58 9 79 323 84 6\n" + "2643 383 2 79 50 288", "87");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC084/C");
	}
}
