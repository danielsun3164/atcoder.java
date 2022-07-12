package abc.abc201_250.abc215;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("aab 2", "aba");
	}

	@Test
	void case2() {
		check("baba 4", "baab");
	}

	@Test
	void case3() {
		check("ydxwacbz 40320", "zyxwdcba");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc215/C");
	}
}
