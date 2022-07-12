package abc.abc151_200.abc184;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 2\n" + "3 4", "-2");
	}

	@Test
	void case2() {
		check("0 -1\n" + "1 0", "1");
	}

	@Test
	void case3() {
		check("100 100\n" + "100 100", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC184/A");
	}
}
