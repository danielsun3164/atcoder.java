package abc.abc151_200.abc188;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "-3 6\n" + "4 2", "Yes");
	}

	@Test
	void case2() {
		check("2\n" + "4 5\n" + "-1 -3", "No");
	}

	@Test
	void case3() {
		check("3\n" + "1 3 5\n" + "3 -6 3", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC188/B");
	}
}
