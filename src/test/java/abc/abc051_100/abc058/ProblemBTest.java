package abc.abc051_100.abc058;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("xyz\n" + "abc", "xaybzc");
	}

	@Test
	void case2() {
		check("atcoderbeginnercontest\n" + "atcoderregularcontest", "aattccooddeerrbreeggiunlnaerrccoonntteesstt");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC071/B");
	}
}
