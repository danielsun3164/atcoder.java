package abc.abc151_200.abc174;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("101", "4");
	}

	@Test
	void case2() {
		check("2", "-1");
	}

	@Test
	void case3() {
		check("999983", "999982");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC174/C");
	}
}
