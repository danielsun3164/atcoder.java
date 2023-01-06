package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem087Test extends TestBase {

	@Test
	void case1() {
		check("3 4 2\n" + "0 3 -1\n" + "3 0 5\n" + "-1 5 0", "3");
	}

	@Test
	void case2() {
		check("3 10 2\n" + "0 -1 10\n" + "-1 0 1\n" + "10 1 0", "Infinity");
	}

	@Test
	void case3() {
		check("13 777 77\n" + "0 425 886 764 736 -1 692 660 -1 316 424 490 423\n"
				+ "425 0 -1 473 -1 311 -1 -1 903 941 386 521 486\n"
				+ "886 -1 0 605 519 473 775 467 677 769 690 483 501\n"
				+ "764 473 605 0 424 454 474 408 421 530 756 568 685\n"
				+ "736 -1 519 424 0 -1 804 598 911 731 837 459 610\n"
				+ "-1 311 473 454 -1 0 479 613 880 -1 393 875 334\n"
				+ "692 -1 775 474 804 479 0 579 -1 -1 575 985 603\n"
				+ "660 -1 467 408 598 613 579 0 456 378 887 -1 372\n"
				+ "-1 903 677 421 911 880 -1 456 0 859 701 476 370\n"
				+ "316 941 769 530 731 -1 -1 378 859 0 800 870 740\n"
				+ "424 386 690 756 837 393 575 887 701 800 0 -1 304\n"
				+ "490 521 483 568 459 875 985 -1 476 870 -1 0 716\n"
				+ "423 486 501 685 610 334 603 372 370 740 304 716 0", "42");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/087");
	}
}
