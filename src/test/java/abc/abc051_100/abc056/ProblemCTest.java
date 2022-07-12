package abc.abc051_100.abc056;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6", "3");
	}

	@Test
	void case2() {
		check("2", "2");
	}

	@Test
	void case3() {
		check("11", "5");
	}

	@Test
	void case4() {
		check("10", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC070/C");
	}
}
