package abc.abc151_200.abc185;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("12", "1");
	}

	@Test
	void case2() {
		check("13", "12");
	}

	@Test
	void case3() {
		check("17", "4368");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC185/C");
	}
}
