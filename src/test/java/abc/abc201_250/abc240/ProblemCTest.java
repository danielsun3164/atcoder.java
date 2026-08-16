package abc.abc201_250.abc240;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 10\n" + "3 6\n" + "4 5", "Yes");
	}

	@Test
	void case2() {
		check("2 10\n" + "10 100\n" + "10 100", "No");
	}

	@Test
	void case3() {
		check("4 12\n" + "1 8\n" + "5 7\n" + "3 4\n" + "2 6", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/C");
	}
}
