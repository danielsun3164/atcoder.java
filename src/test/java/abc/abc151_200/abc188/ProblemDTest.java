package abc.abc151_200.abc188;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 6\n" + "1 2 4\n" + "2 2 4", "10");
	}

	@Test
	void case2() {
		check("5 1000000000\n" + "583563238 820642330 44577\n" + "136809000 653199778 90962\n"
				+ "54601291 785892285 50554\n" + "5797762 453599267 65697\n" + "468677897 916692569 87409",
				"163089627821228");
	}

	@Test
	void case3() {
		check("5 100000\n" + "583563238 820642330 44577\n" + "136809000 653199778 90962\n"
				+ "54601291 785892285 50554\n" + "5797762 453599267 65697\n" + "468677897 916692569 87409",
				"88206004785464");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC188/D");
	}
}
