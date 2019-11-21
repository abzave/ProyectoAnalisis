package common;

public interface ITestConstants {
	public final int AMOUNT_OF_TESTS = 3;
	public final int TEST_POSICION_HORMIGUERO = 1000;
	public final double GROW_PERCENTAGE = 0.85;
	
	//QUANTITY(0), MIN_DISTANCE(1), MAX_DISTANCE(2), MIN_LENGTH(3), MAX_LENGTH(4), MIN_LEVELS(5), MAX_LEVELS(6);
	public final int TEST_RULES[][][] = {
		{
			{10,10,100,60,100,8,8},
			{10,100,200,60,100,8,8},
			{10,200,300,60,100,8,8},
			{10,300,400,60,100,8,8},
			{10,400,500,60,100,8,8},
			{10,500,600,60,100,8,8},
			{10,600,700,60,100,8,8},
			{10,700,800,60,100,8,8},
			{10,800,900,60,100,8,8},
		},
		{
			{40,10,400,80,170,4,12},
			{5,600,610,130,130,18,18},
			{2,700,700,60,70,17,18},
		},
		{
			{50,10,500,40,40,18,18},
			{200,10,500,160,160,14,14},
			{600,10,500,60,60,4,4},
		}		
	};
}
