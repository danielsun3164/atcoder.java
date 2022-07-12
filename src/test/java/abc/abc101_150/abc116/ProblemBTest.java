package abc.abc101_150.abc116;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("8", "5");
	}

	@Test
	void case2() {
		check("7", "18");
	}

	@Test
	void case3() {
		check("54", "114");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC116/B");
	}
}
