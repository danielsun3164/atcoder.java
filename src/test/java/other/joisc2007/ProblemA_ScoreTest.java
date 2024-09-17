package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemA_ScoreTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "100\n" + "90\n" + "80\n" + "90\n" + "100\n" + "65",
				"1" + LF + "3" + LF + "5" + LF + "3" + LF + "1" + LF + "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Score");
	}
}
