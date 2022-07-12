package abc.abc051_100.abc066;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abaababaab", "6");
	}

	@Test
	void case2() {
		check("xxxx", "2");
	}

	@Test
	void case3() {
		check("abcabcabcabc", "6");
	}

	@Test
	void case4() {
		check("akasakaakasakasakaakas", "14");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC077/B");
	}
}
