package abc.abc201_250.abc214;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3\n" + "1 2\n" + "2 3\n" + "3 3\n" + "5\n" + "1 2\n" + "2 3\n" + "3 3\n" + "1 3\n"
				+ "999999999 1000000000", "Yes" + LF + "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc214/E");
	}
}
