package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("4 1\n" + "1", "1" + LF + "2" + LF + "4");
	}

	@Test
	void case2() {
		check("10 10\n" + "1 2 3 4 5 6 7 8 9 10",
				"1" + LF + "3" + LF + "7" + LF + "18" + LF + "45" + LF + "121" + LF + "325" + LF + "904" + LF + "2546");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/H");
	}
}
