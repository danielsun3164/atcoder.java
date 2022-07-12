package abc.abc151_200.abc165;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "500 600", "OK");
	}

	@Test
	void case2() {
		check("4\n" + "5 7", "NG");
	}

	@Test
	void case3() {
		check("1\n" + "11 11", "OK");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC165/A");
	}
}
