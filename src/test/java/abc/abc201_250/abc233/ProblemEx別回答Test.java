package abc.abc201_250.abc233;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemEx別回答Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 3\n" + "4 6\n" + "7 4\n" + "2 5\n" + "6\n" + "3 5 1\n" + "3 5 2\n" + "3 5 3\n" + "3 5 4\n"
				+ "100 200 3\n" + "300 200 1", "1" + LF + "2" + LF + "2" + LF + "5" + LF + "293" + LF + "489");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/Ex");
	}
}
