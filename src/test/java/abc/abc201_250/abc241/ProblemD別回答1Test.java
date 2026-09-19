package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答1Test extends TestBase {

	@Test
	void case1() {
		check("11\n" + "1 20\n" + "1 10\n" + "1 30\n" + "1 20\n" + "3 15 1\n" + "3 15 2\n" + "3 15 3\n" + "3 15 4\n"
				+ "2 100 5\n" + "1 1\n" + "2 100 5", "20" + LF + "20" + LF + "30" + LF + "-1" + LF + "-1" + LF + "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/D");
	}
}
