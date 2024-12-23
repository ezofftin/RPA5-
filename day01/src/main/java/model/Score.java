package model;

public class Score {
	private int total; // 총점
	
	// 비즈니스 로직(핵심로직)
	public Score(int kor, int eng, int mat) {
		this.total = kor + eng + mat;
	}
	
	public String avg() {
		double avg = total/3.0;
		
		String strAvg = String.format("%.2f", avg);
		
		return strAvg;
	}
	
	public int getTotal() {
		return total;
	}
}
