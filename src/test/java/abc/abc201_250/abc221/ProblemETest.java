package abc.abc201_250.abc221;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 1", "3");
	}

	@Test
	void case2() {
		check("3\n" + "1 2 2", "4");
	}

	@Test
	void case3() {
		check("3\n" + "3 2 1", "0");
	}

	@Test
	void case4() {
		check("10\n"
				+ "198495780 28463047 859606611 212983738 946249513 789612890 782044670 700201033 367981604 302538501",
				"830");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/E");
	}
}
