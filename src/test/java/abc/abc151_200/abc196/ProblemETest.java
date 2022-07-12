package abc.abc151_200.abc196;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "-10 2\n" + "10 1\n" + "10 3\n" + "5\n" + "-15 -10 -5 0 5",
				"0" + LF + "0" + LF + "5" + LF + "10" + LF + "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC196/E");
	}
}
