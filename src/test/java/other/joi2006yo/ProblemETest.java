package other.joi2006yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 1 0 5", "0.50000");
	}

	@Test
	void case2() {
		check("3 1 1 3", "0.833");
	}

	@Test
	void case3() {
		check("2 2 1 3", "1.000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2006yo/E");
	}
}
