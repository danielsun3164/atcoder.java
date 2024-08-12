package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3", "2");
	}

	@Test
	void case2() {
		check("4\n" + "1 10 1 10", "90");
	}

	@Test
	void case3() {
		check("10\n"
				+ "699498050 759726383 769395239 707559733 72435093 537050110 880264078 699299140 418322627 134917794",
				"877646588");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/G");
	}
}
