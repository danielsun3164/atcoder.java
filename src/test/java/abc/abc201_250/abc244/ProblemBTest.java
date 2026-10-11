package abc.abc201_250.abc244;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "SSRS", "2 -1");
	}

	@Test
	void case2() {
		check("20\n" + "SRSRSSRSSSRSRRRRRSRR", "0 1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/B");
	}
}
