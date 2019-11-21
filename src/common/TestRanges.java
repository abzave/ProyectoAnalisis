package common;

public enum TestRanges {
	QUANTITY(0), MIN_DISTANCE(1), MAX_DISTANCE(2), MIN_LENGTH(3), MAX_LENGTH(4), MIN_LEVELS(5), MAX_LEVELS(6);
	
	private final int index;
	
	TestRanges(int pIndex) {
		this.index = pIndex;
	}
	
	int getIndex() {
		return this.index;
	}
}
