package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemB_FactorialTest extends TestBase {

	@Test
	void case1() {
		check("10", "5");
	}

	@Test
	void case2() {
		check("12", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Factorial");
	}
}
