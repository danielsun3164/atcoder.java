package abc.abc201_250.abc201;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("ooo???xxxx", "108");
	}

	@Test
	void case2() {
		check("o?oo?oxoxo", "0");
	}

	@Test
	void case3() {
		check("xxxxx?xxxo", "15");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc201/C");
	}
}
