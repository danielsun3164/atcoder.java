package abc.abc201_250.abc225;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("aba", "3");
	}

	@Test
	void case2() {
		check("ccc", "1");
	}

	@Test
	void case3() {
		check("xyz", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc225/A");
	}
}
