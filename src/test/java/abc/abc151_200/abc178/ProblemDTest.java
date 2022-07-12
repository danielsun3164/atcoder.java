package abc.abc151_200.abc178;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("7", "3");
	}

	@Test
	void case2() {
		check("2", "0");
	}

	@Test
	void case3() {
		check("1729", "294867501");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC178/D");
	}
}
