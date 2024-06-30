package abc.abc201_250.abc225;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 1\n" + "2 1\n" + "1 2", "2");
	}

	@Test
	void case2() {
		check("10\n" + "414598724 87552841\n" + "252911401 309688555\n" + "623249116 421714323\n"
				+ "605059493 227199170\n" + "410455266 373748111\n" + "861647548 916369023\n" + "527772558 682124751\n"
				+ "356101507 249887028\n" + "292258775 110762985\n" + "850583108 796044319", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc225/E");
	}
}
