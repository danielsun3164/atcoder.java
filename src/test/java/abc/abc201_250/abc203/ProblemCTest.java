package abc.abc201_250.abc203;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "2 1\n" + "5 10", "4");
	}

	@Test
	void case2() {
		check("5 1000000000\n" + "1 1000000000\n" + "2 1000000000\n" + "3 1000000000\n" + "4 1000000000\n"
				+ "5 1000000000", "6000000000");
	}

	@Test
	void case3() {
		check("3 2\n" + "5 5\n" + "2 1\n" + "2 2", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc203/C");
	}
}
