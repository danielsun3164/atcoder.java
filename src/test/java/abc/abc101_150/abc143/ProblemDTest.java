package abc.abc101_150.abc143;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 4 2 1", "1");
	}

	@Test
	void case2() {
		check("3\n" + "1 1000 1", "0");
	}

	@Test
	void case3() {
		check("7\n" + "218 786 704 233 645 728 389", "23");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC143/D");
	}
}
