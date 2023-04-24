package finalpackage;


public enum RPE {
	EASY(0 , 3),
	MEDIUM(4 , 7 ),
	HARD(8 , 10);
	private int lowerLevel;
	private int higherLevel;
	
	
	private RPE(int lowerLevel, int higherLevel) {
		this.lowerLevel = lowerLevel;
		this.higherLevel = higherLevel;
	}
	
	public static RPE defineCategory(int number) {
		
		for(RPE sc: RPE.values()) {
			
			if(number>= sc.lowerLevel && number<= sc.higherLevel ) {
				return sc;
			}
			
		}
		
		return EASY;
	}
}
