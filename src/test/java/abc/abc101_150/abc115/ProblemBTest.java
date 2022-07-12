package abc.abc101_150.abc115;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4980\n" + "7980\n" + "6980", "15950");
	}

	@Test
	void case2() {
		check("4\n" + "4320\n" + "4320\n" + "4320\n" + "4320", "15120");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC115/B");
	}
}
