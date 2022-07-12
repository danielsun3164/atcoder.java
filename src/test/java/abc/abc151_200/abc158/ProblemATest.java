package abc.abc151_200.abc158;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("ABA", "Yes");
	}

	@Test
	void case2() {
		check("BBA", "Yes");
	}

	@Test
	void case3() {
		check("BBB", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC158/A");
	}
}
