package abc.abc101_150.abc113;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1 3 2", "1");
	}

	@Test
	void case2() {
		check("1 3 1", "2");
	}

	@Test
	void case3() {
		check("2 3 3", "1");
	}

	@Test
	void case4() {
		check("2 3 1", "5");
	}

	@Test
	void case5() {
		check("7 1 1", "1");
	}

	@Test
	void case6() {
		check("15 8 5", "437760187");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC113/D");
	}
}
