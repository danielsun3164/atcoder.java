package abc.abc151_200.abc167;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("chokudai\n" + "chokudaiz", "Yes");
	}

	@Test
	void case2() {
		check("snuke\n" + "snekee", "No");
	}

	@Test
	void case3() {
		check("a\n" + "aa", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC167/A");
	}
}
