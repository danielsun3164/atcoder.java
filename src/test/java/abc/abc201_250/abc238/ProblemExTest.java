package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "LLR", "831870297");
	}

	@Test
	void case2() {
		check("10\n" + "RRRRRRLLRR", "460301586");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/Ex");
	}
}
