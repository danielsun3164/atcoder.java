package abc.abc201_250.abc240;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 5", "Yes");
	}

	@Test
	void case2() {
		check("3 5", "No");
	}

	@Test
	void case3() {
		check("1 10", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/A");
	}
}
