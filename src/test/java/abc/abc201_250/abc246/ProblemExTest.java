package abc.abc201_250.abc246;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "100\n" + "2 1\n" + "2 ?\n" + "3 ?", "5" + LF + "7" + LF + "10");
	}

	@Test
	void case2() {
		check("40 10\n" + "011?0??001??10?0??0?0?1?11?1?00?11??0?01\n" + "5 0\n" + "2 ?\n" + "30 ?\n" + "7 1\n"
				+ "11 1\n" + "3 1\n" + "25 1\n" + "40 0\n" + "12 1\n" + "18 1",
				"746884092" + LF + "532460539" + LF + "299568633" + LF + "541985786" + LF + "217532539" + LF
						+ "217532539" + LF + "217532539" + LF + "573323772" + LF + "483176957" + LF + "236273405");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/Ex");
	}
}
