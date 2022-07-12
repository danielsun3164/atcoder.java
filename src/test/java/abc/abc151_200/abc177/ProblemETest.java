package abc.abc151_200.abc177;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 4 5", "pairwise coprime");
	}

	@Test
	void case2() {
		check("3\n" + "6 10 15", "setwise coprime");
	}

	@Test
	void case3() {
		check("3\n" + "6 10 16", "not coprime");
	}

	@Test
	void case4() {
		check("4\n" + "6 10 16 999983", "setwise coprime");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC177/E");
	}
}
