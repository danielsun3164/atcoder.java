package abc.abc101_150.abc125;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "7 6 8", "2");
	}

	@Test
	void case2() {
		check("3\n" + "12 15 18", "6");
	}

	@Test
	void case3() {
		check("2\n" + "1000000000 1000000000", "1000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC125/C");
	}
}
