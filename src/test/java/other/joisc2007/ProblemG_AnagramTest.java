package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG_AnagramTest extends TestBase {

	@Test
	void case1() {
		check("HEART", "55");
	}

	@Test
	void case2() {
		check("IOI", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Anagram");
	}
}
