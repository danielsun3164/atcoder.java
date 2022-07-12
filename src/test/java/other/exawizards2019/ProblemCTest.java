package other.exawizards2019;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "ABC\n" + "A L\n" + "B L\n" + "B R\n" + "A R", "2");
	}

	@Test
	void case2() {
		check("8 3\n" + "AABCBDBA\n" + "A L\n" + "B R\n" + "A R", "5");
	}

	@Test
	void case3() {
		check("10 15\n" + "SNCZWRCEWB\n" + "B R\n" + "R R\n" + "E R\n" + "W R\n" + "Z L\n" + "S R\n" + "Q L\n" + "W L\n"
				+ "B R\n" + "C L\n" + "A L\n" + "N L\n" + "E R\n" + "Z L\n" + "S L", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("2019exa/C");
	}
}
