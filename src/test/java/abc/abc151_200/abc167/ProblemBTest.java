package abc.abc151_200.abc167;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 1 1 3", "2");
	}

	@Test
	void case2() {
		check("1 2 3 4", "0");
	}

	@Test
	void case3() {
		check("2000000000 0 0 2000000000", "2000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC167/B");
	}
}
