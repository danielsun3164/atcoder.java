package abc.abc001_050.abc049;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("a", "vowel");
	}

	@Test
	void case2() {
		check("z", "consonant");
	}

	@Test
	void case3() {
		check("s", "consonant");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC065/A");
	}
}
