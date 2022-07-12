package abc.abc201_250.abc203;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 2", "203");
	}

	@Test
	void case2() {
		check("3 3", "1818");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc203/B");
	}
}
