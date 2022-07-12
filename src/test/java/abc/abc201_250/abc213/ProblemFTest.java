package abc.abc201_250.abc213;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "abb", "3" + LF + "3" + LF + "2");
	}

	@Test
	void case2() {
		check("11\n" + "mississippi", "11" + LF + "16" + LF + "14" + LF + "12" + LF + "13" + LF + "11" + LF + "9" + LF
				+ "7" + LF + "4" + LF + "3" + LF + "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc213/F");
	}
}
