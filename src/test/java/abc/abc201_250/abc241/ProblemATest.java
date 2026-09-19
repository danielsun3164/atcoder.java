package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("9 0 1 2 3 4 5 6 7 8", "7");
	}

	@Test
	void case2() {
		check("4 8 8 8 0 8 8 8 8 8", "4");
	}

	@Test
	void case3() {
		check("0 0 0 0 0 0 0 0 0 0", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/A");
	}
}
