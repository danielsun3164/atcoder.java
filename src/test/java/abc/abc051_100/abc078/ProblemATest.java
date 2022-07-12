package abc.abc051_100.abc078;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("A B", "<");
	}

	@Test
	void case2() {
		check("E C", ">");
	}

	@Test
	void case3() {
		check("F F", "=");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC085/A");
	}
}
