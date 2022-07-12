package abc.abc151_200.abc158;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "25");
	}

	@Test
	void case2() {
		check("8 10", "100");
	}

	@Test
	void case3() {
		check("19 99", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC158/C");
	}
}
