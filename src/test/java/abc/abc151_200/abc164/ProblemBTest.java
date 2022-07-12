package abc.abc151_200.abc164;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10 9 10 10", "No");
	}

	@Test
	void case2() {
		check("46 4 40 5", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC164/B");
	}
}
