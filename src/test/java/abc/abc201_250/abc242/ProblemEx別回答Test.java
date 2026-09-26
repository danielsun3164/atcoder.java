package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemEx別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 1\n" + "1 2\n" + "2 3", "499122180");
	}

	@Test
	void case2() {
		check("13 10\n" + "3 5\n" + "5 9\n" + "3 12\n" + "1 13\n" + "9 11\n" + "12 13\n" + "2 4\n" + "9 12\n" + "9 11\n"
				+ "7 11", "10");
	}

	@Test
	void case3() {
		check("100 11\n" + "22 43\n" + "84 93\n" + "12 71\n" + "49 56\n" + "8 11\n" + "1 61\n" + "13 80\n" + "26 83\n"
				+ "23 100\n" + "80 85\n" + "9 89", "499122193");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/Ex");
	}
}
