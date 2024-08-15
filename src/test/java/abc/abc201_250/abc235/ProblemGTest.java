package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("2 2 1 1", "21");
	}

	@Test
	void case2() {
		check("2 0 0 0", "0");
	}

	@Test
	void case3() {
		check("2 0 2 2", "9");
	}

	@Test
	void case4() {
		check("100 12 34 56", "769445780");
	}

	@Test
	void case5() {
		check("5000000 2521993 2967363 3802088", "264705492");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/G");
	}
}
