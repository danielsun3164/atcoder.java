package abc.abc001_050.abc050;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3", "5");
	}

	@Test
	void case2() {
		check("1422", "52277");
	}

	@Test
	void case3() {
		check("1000000000000000000", "787014179");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC066/D");
	}
}
