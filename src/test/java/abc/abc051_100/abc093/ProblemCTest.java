package abc.abc051_100.abc093;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 5 4", "2");
	}

	@Test
	void case2() {
		check("2 6 3", "5");
	}

	@Test
	void case3() {
		check("31 41 5", "23");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC094/C");
	}
}
