package abc.abc201_250.abc221;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemH別回答1Test extends TestBase {

	@Test
	void case1() {
		check("4 2", "1" + LF + "2" + LF + "1" + LF + "0");
	}

	@Test
	void case2() {
		check("7 7", "1" + LF + "3" + LF + "4" + LF + "3" + LF + "2" + LF + "1" + LF + "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/H");
	}
}
