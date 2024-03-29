package abc.abc151_200.abc200;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("101\n" + "2", "2");
	}

	@Test
	void case2() {
		check("?0?\n" + "1", "3");
	}

	@Test
	void case3() {
		check("10111?10??1101??1?00?1?01??00010?0?1??\n" + "998244353", "235562598");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc200/F");
	}
}
