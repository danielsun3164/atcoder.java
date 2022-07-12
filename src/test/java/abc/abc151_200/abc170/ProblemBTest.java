package abc.abc151_200.abc170;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 8", "Yes");
	}

	@Test
	void case2() {
		check("2 100", "No");
	}

	@Test
	void case3() {
		check("1 2", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC170/B");
	}
}
