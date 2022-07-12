package abc.abc101_150.abc133;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "1 2 1 10\n" + "1 3 2 20\n" + "2 4 4 30\n" + "5 2 1 40\n" + "1 100 1 4\n" + "1 100 1 5\n"
				+ "3 1000 3 4", "130" + LF + "200" + LF + "60");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC133/F");
	}
}
