package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("229 390", "Hard");
	}

	@Test
	void case2() {
		check("123456789 9876543210", "Easy");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/B");
	}
}
