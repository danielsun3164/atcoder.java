package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5", "Yes");
	}

	@Test
	void case2() {
		check("2", "No");
	}

	@Test
	void case3() {
		check("623947744", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/A");
	}
}
