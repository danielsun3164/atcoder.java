package abc.abc151_200.abc198;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1210", "Yes");
	}

	@Test
	void case2() {
		check("777", "Yes");
	}

	@Test
	void case3() {
		check("123456789", "No");
	}

	@Test
	void case4() {
		check("0", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc198/B");
	}
}
