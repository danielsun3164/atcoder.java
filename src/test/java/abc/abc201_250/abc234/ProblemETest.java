package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("152", "159");
	}

	@Test
	void case2() {
		check("88", "88");
	}

	@Test
	void case3() {
		check("8989898989", "9876543210");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/E");
	}
}
