package abc.abc101_150.abc147;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("redcoder", "1");
	}

	@Test
	void case2() {
		check("vvvvvv", "0");
	}

	@Test
	void case3() {
		check("abcdabc", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC147/B");
	}
}
