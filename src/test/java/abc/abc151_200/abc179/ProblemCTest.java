package abc.abc151_200.abc179;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3", "3");
	}

	@Test
	void case2() {
		check("100", "473");
	}

	@Test
	void case3() {
		check("1000000", "13969985");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC179/C");
	}
}
