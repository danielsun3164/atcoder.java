package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答3Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3 1 4 1 5\n" + "4\n" + "1 5 1\n" + "2 4 3\n" + "1 5 2\n" + "1 3 3",
				"2" + LF + "0" + LF + "0" + LF + "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/D");
	}
}
