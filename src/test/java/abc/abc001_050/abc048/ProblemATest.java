package abc.abc001_050.abc048;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("AtCoder Beginner Contest", "ABC");
	}

	@Test
	void case2() {
		check("AtCoder Snuke Contest", "ASC");
	}

	@Test
	void case3() {
		check("AtCoder X Contest", "AXC");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC064/A");
	}
}
