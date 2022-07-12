package abc.abc001_050.abc048;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("aba", "Second");
	}

	@Test
	void case2() {
		check("abc", "First");
	}

	@Test
	void case3() {
		check("abcab", "First");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC064/D");
	}
}
