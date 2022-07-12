package abc.abc101_150.abc108;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3", "2");
	}

	@Test
	void case2() {
		check("6", "9");
	}

	@Test
	void case3() {
		check("11", "30");
	}

	@Test
	void case4() {
		check("50", "625");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC108/A");
	}
}
