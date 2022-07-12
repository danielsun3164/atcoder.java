package abc.abc051_100.abc093;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("bac", "Yes");
	}

	@Test
	void case2() {
		check("bab", "No");
	}

	@Test
	void case3() {
		check("abc", "Yes");
	}

	@Test
	void case4() {
		check("aaa", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC094/A");
	}
}
