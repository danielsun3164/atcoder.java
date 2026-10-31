package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "24 30 28 7\n" + "1 2\n" + "1 3\n" + "3 4", "47");
	}

	@Test
	void case2() {
		check("10\n" + "180 168 120 144 192 200 198 160 156 150\n" + "1 2\n" + "2 3\n" + "2 4\n" + "2 5\n" + "5 6\n"
				+ "4 7\n" + "7 8\n" + "7 9\n" + "9 10", "1184");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/G");
	}
}
