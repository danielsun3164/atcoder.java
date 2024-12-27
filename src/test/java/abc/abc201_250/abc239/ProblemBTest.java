package abc.abc201_250.abc239;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("47", "4");
	}

	@Test
	void case2() {
		check("-24", "-3");
	}

	@Test
	void case3() {
		check("50", "5");
	}

	@Test
	void case4() {
		check("-30", "-3");
	}

	@Test
	void case5() {
		check("987654321987654321", "98765432198765432");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/B");
	}
}
