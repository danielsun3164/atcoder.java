package abc.abc151_200.abc164;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1817181712114", "3");
	}

	@Test
	void case2() {
		check("14282668646", "2");
	}

	@Test
	void case3() {
		check("2119", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC164/D");
	}
}
