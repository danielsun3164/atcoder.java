package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("##\n" + ".#", "Yes");
	}

	@Test
	void case2() {
		check(".#\n" + "#.", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/A");
	}
}
