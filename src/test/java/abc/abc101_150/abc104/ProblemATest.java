package abc.abc101_150.abc104;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1199", "ABC");
	}

	@Test
	void case2() {
		check("1200", "ARC");
	}

	@Test
	void case3() {
		check("4208", "AGC");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC104/A");
	}
}
