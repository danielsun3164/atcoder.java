package abc.abc051_100.abc091;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("50 100 120", "Yes");
	}

	@Test
	void case2() {
		check("500 100 1000", "No");
	}

	@Test
	void case3() {
		check("19 123 143", "No");
	}

	@Test
	void case4() {
		check("19 123 142", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC092/A");
	}
}
