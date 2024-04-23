package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("aaba", "aaab" + LF + "baaa");
	}

	@Test
	void case2() {
		check("z", "z" + LF + "z");
	}

	@Test
	void case3() {
		check("abracadabra", "aabracadabr" + LF + "racadabraab");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/B");
	}
}
