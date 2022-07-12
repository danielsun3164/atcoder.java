package abc.abc101_150.abc129;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("10", "5");
	}

	@Test
	void case2() {
		check("1111111111111111111", "162261460");
	}

	@Test
	void case3() {
		check("100", "11");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC129/E");
	}
}
