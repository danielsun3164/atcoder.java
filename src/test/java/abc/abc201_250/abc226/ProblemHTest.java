package abc.abc201_250.abc226;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("1 1\n" + "0 2", "1");
	}

	@Test
	void case2() {
		check("2 2\n" + "0 2\n" + "1 3", "707089751");
	}

	@Test
	void case3() {
		check("10 5\n" + "35 48\n" + "44 64\n" + "47 59\n" + "39 97\n" + "36 37\n" + "4 91\n" + "38 82\n" + "20 84\n"
				+ "38 50\n" + "39 69", "810056397");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc226/H");
	}
}
