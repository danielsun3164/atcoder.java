package abc.abc051_100.abc090;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("ant\n" + "obe\n" + "rec", "abc");
	}

	@Test
	void case2() {
		check("edu\n" + "cat\n" + "ion", "ean");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC091/A");
	}
}
