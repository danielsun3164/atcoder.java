package abc.abc051_100.abc054;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 1 1\n" + "1 2 1\n" + "2 1 2\n" + "3 3 10", "3");
	}

	@Test
	void case2() {
		check("1 1 10\n" + "10 10 10", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC054/D");
	}
}
