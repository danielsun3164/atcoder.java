package abc.abc001_050.abc045;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4\n" + "2", "7");
	}

	@Test
	void case2() {
		check("4\n" + "4\n" + "4", "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC061/A");
	}
}
