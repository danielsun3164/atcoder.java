package abc.abc151_200.abc194;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 8", "1");
	}

	@Test
	void case2() {
		check("1 2", "3");
	}

	@Test
	void case3() {
		check("0 0", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC194/A");
	}
}
