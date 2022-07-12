package abc.abc001_050.abc050;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 + 2", "3");
	}

	@Test
	void case2() {
		check("5 - 7", "-2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC066/A");
	}
}
