package abc.abc201_250.abc204;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("0 1", "2");
	}

	@Test
	void case2() {
		check("0 0", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc204/A");
	}
}
