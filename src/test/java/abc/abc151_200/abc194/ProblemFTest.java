package abc.abc151_200.abc194;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("10 1", "15");
	}

	@Test
	void case2() {
		check("FF 2", "225");
	}

	@Test
	void case3() {
		check("100 2", "226");
	}

	@Test
	void case4() {
		check("1A8FD02 4", "3784674");
	}

	@Test
	void case5() {
		check("DEADBEEFDEADBEEEEEEEEF 16", "153954073");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC194/F");
	}
}
