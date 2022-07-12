package other.exawizards2019;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 19\n" + "3 7", "3");
	}

	@Test
	void case2() {
		check("5 82\n" + "22 11 6 5 13", "288");
	}

	@Test
	void case3() {
		check("10 100000\n" + "50000 50001 50002 50003 50004 50005 50006 50007 50008 50009", "279669259");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("2019exa/D");
	}
}
