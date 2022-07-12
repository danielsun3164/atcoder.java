package abc.abc201_250.abc214;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("214", "8");
	}

	@Test
	void case2() {
		check("1", "4");
	}

	@Test
	void case3() {
		check("126", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc214/A");
	}
}
