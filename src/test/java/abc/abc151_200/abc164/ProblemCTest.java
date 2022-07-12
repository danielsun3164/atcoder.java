package abc.abc151_200.abc164;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "apple\n" + "orange\n" + "apple", "2");
	}

	@Test
	void case2() {
		check("5\n" + "grape\n" + "grape\n" + "grape\n" + "grape\n" + "grape", "1");
	}

	@Test
	void case3() {
		check("4\n" + "aaaa\n" + "a\n" + "aaa\n" + "aa", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC164/C");
	}
}
