package abc.abc201_250.abc227;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("5 2", "4");
	}

	@Test
	void case2() {
		check("103 3", "8");
	}

	@Test
	void case3() {
		check("1000000000000 1000000", "110520107");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/G");
	}
}
