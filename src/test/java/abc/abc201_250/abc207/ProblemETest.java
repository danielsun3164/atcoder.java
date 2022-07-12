package abc.abc201_250.abc207;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2 3 4", "3");
	}

	@Test
	void case2() {
		check("5\n" + "8 6 3 3 3", "5");
	}

	@Test
	void case3() {
		check("10\n"
				+ "791754273866483 706434917156797 714489398264550 918142301070506 559125109706263 694445720452148 648739025948445 869006293795825 718343486637033 934236559762733",
				"15");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc207/E");
	}
}
