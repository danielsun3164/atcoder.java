package abc.abc101_150.abc149;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "8 7 6\n" + "rsrpr", "27");
	}

	@Test
	void case2() {
		check("7 1\n" + "100 10 1\n" + "ssssppr", "211");
	}

	@Test
	void case3() {
		check("30 5\n" + "325 234 123\n" + "rspsspspsrpspsppprpsprpssprpsr", "4996");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC149/D");
	}
}
