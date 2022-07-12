package abc.abc051_100.abc051;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2 1\n" + "1 3 1\n" + "2 3 3", "1");
	}

	@Test
	void case2() {
		check("3 2\n" + "1 2 1\n" + "2 3 1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC051/D");
	}
}
