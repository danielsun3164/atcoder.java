package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 3 1", "3 1 2");
	}

	@Test
	void case2() {
		check("3\n" + "1 2 3", "1 2 3");
	}

	@Test
	void case3() {
		check("5\n" + "5 3 2 4 1", "5 3 2 4 1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/C");
	}
}
