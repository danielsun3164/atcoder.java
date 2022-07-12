package abc.abc001_050.abc044;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3\n" + "10000\n" + "9000", "48000");
	}

	@Test
	void case2() {
		check("2\n" + "3\n" + "10000\n" + "9000", "20000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC060/A");
	}
}
