package abc.abc051_100.abc062;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 3", "Yes");
	}

	@Test
	void case2() {
		check("2 4", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC074/A");
	}
}
