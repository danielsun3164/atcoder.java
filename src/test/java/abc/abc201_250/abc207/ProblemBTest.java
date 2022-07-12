package abc.abc201_250.abc207;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 2 3 2", "2");
	}

	@Test
	void case2() {
		check("6 9 2 3", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc207/B");
	}
}
