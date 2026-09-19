package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("7 8 7\n" + "3 4\n" + "5 6\n" + "1 4\n" + "2 1\n" + "2 8\n" + "4 5\n" + "5 7\n" + "6 2\n" + "6 6", "4");
	}

	@Test
	void case2() {
		check("4 6 2\n" + "3 2\n" + "3 5\n" + "4 5\n" + "2 5", "-1");
	}

	@Test
	void case3() {
		check("1 10 1\n" + "1 5\n" + "1 1\n" + "1 7", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/F");
	}
}
