package abc.abc151_200.abc197;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("8 8\n" + "1 2 a\n" + "2 3 b\n" + "1 3 c\n" + "3 4 b\n" + "4 5 a\n" + "5 6 c\n" + "6 7 b\n" + "7 8 a",
				"10");
	}

	@Test
	void case2() {
		check("4 5\n" + "1 1 a\n" + "1 2 a\n" + "2 3 a\n" + "3 4 b\n" + "4 4 a", "5");
	}

	@Test
	void case3() {
		check("3 4\n" + "1 1 a\n" + "1 2 a\n" + "2 3 b\n" + "3 3 b", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC197/F");
	}
}
