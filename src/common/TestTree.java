package common;


public class TestTree {
	int posX;
	int length;
	int levels;
	double leafLength;

	public TestTree(int pPosX, int pLength, int pLevels) {
		this.posX = pPosX;
		this.length = pLength;
		this.levels = pLevels;
		
		for(leafLength=pLength; --pLevels>0; leafLength*=ITestConstants.GROW_PERCENTAGE);
	}

	public int getPosX() {
		return posX;
	}

	public int getLength() {
		return length;
	}

	public int getLevels() {
		return levels;
	}
	
	public double getGrow_percentage() {
		return ITestConstants.GROW_PERCENTAGE;
	}
	
	public double getLeafLength() {
		return this.leafLength;
	}
}
