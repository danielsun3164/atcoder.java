package abc.abc101_150.abc135;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 16", "9");
	}

	@Test
	void case2() {
		check("0 3", "IMPOSSIBLE");
	}

	@Test
	void case3() {
		check("998244353 99824435", "549034394");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC135/A");
	}
}
