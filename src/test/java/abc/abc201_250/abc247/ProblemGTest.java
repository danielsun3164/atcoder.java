package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 1 100\n" + "1 20 10\n" + "2 1 1", "2" + LF + "100" + LF + "11");
	}

	@Test
	void case2() {
		check("10\n" + "1 4 142135623\n" + "2 6 457513110\n" + "3 1 622776601\n" + "5 1 961524227\n" + "2 2 360679774\n"
				+ "2 4 494897427\n" + "3 7 416573867\n" + "5 2 915026221\n" + "1 7 320508075\n" + "5 3 851648071",
				"4" + LF + "961524227" + LF + "1537802822" + LF + "2032700249" + LF + "2353208324");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/G");
	}
}
