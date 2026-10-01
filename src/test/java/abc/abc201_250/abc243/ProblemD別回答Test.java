package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "URL", "6");
	}

	@Test
	void case2() {
		check("4 500000000000000000\n" + "RRUU", "500000000000000000");
	}

	@Test
	void case3() {
		check("30 123456789\n" + "LRULURLURLULULRURRLRULRRRUURRU", "126419752371");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/D");
	}
}
