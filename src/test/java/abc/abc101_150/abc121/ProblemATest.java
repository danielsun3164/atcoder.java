package abc.abc101_150.abc121;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "2 1", "1");
	}

	@Test
	void case2() {
		check("5 5\n" + "2 3", "6");
	}

	@Test
	void case3() {
		check("2 4\n" + "2 4", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC121/A");
	}
}
