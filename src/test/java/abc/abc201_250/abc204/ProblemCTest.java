package abc.abc201_250.abc204;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "2 3\n" + "3 2", "7");
	}

	@Test
	void case2() {
		check("3 0", "3");
	}

	@Test
	void case3() {
		check("4 4\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 1", "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc204/C");
	}
}
