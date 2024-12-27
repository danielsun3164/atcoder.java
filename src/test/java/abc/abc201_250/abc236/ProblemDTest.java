package abc.abc201_250.abc236;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "4 0 1\n" + "5 3\n" + "2", "6");
	}

	@Test
	void case2() {
		check("1\n" + "5", "5");
	}

	@Test
	void case3() {
		check("5\n" + "900606388 317329110 665451442 1045743214 260775845 726039763 57365372 741277060 944347467\n"
				+ "369646735 642395945 599952146 86221147 523579390 591944369 911198494 695097136\n"
				+ "138172503 571268336 111747377 595746631 934427285 840101927 757856472\n"
				+ "655483844 580613112 445614713 607825444 252585196 725229185\n"
				+ "827291247 105489451 58628521 1032791417 152042357\n" + "919691140 703307785 100772330 370415195\n"
				+ "666350287 691977663 987658020\n" + "1039679956 218233643\n" + "70938785", "1073289207");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/D");
	}
}
