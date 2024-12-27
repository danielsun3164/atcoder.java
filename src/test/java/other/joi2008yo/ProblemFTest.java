package other.joi2008yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 8\n" + "1 3 1 10\n" + "0 2 3\n" + "1 2 3 20\n" + "1 1 2 5\n" + "0 3 2\n" + "1 1 3 7\n" + "1 2 1 9\n"
				+ "0 2 3", "-1" + LF + "15" + LF + "12");
	}

	@Test
	void case2() {
		check("5 16\n" + "1 1 2 343750\n" + "1 1 3 3343\n" + "1 1 4 347392\n" + "1 1 5 5497\n" + "1 2 3 123394\n"
				+ "1 2 4 545492\n" + "1 2 5 458\n" + "1 3 4 343983\n" + "1 3 5 843468\n" + "1 4 5 15934\n" + "0 2 1\n"
				+ "0 4 1\n" + "0 3 2\n" + "0 4 2\n" + "0 4 3\n" + "0 5 3",
				"5955" + LF + "21431" + LF + "9298" + LF + "16392" + LF + "24774" + LF + "8840");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2008yo/F");
	}
}
