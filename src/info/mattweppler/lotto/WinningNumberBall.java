package info.mattweppler.lotto;

public class WinningNumberBall extends GameBall
{
	private int firstDrawnFrequency;
	private int secondDrawnFrequency;
	private int thirdDrawnFrequency;
	private int fourthDrawnFrequency;
	private int fifthDrawnFrequency;
	public int getFirstDrawnFrequency()
	{
		return firstDrawnFrequency;
	}
	public int getSecondDrawnFrequency()
	{
		return secondDrawnFrequency;
	}
	public int getThirdDrawnFrequency()
	{
		return thirdDrawnFrequency;
	}
	public int getFourthDrawnFrequency()
	{
		return fourthDrawnFrequency;
	}
	public int getFifthDrawnFrequency()
	{
		return fifthDrawnFrequency;
	}
	public void setFirstDrawnFrequency(int firstDrawnFrequency)
	{
		this.firstDrawnFrequency = firstDrawnFrequency;
	}
	public void setSecondDrawnFrequency(int secondDrawnFrequency)
	{
		this.secondDrawnFrequency = secondDrawnFrequency;
	}
	public void setThirdDrawnFrequency(int thirdDrawnFrequency)
	{
		this.thirdDrawnFrequency = thirdDrawnFrequency;
	}
	public void setFourthDrawnFrequency(int fourthDrawnFrequency)
	{
		this.fourthDrawnFrequency = fourthDrawnFrequency;
	}
	public void setFifthDrawnFrequency(int fifthDrawnFrequency)
	{
		this.fifthDrawnFrequency = fifthDrawnFrequency;
	}
	@Override
	public String toString()
	{
		return "WinningNumberBall [label=" + label + ", drawnFrequency="
				+ drawnFrequency + ", firstDrawnFrequency="
				+ firstDrawnFrequency + ", secondDrawnFrequency="
				+ secondDrawnFrequency + ", thirdDrawnFrequency="
				+ thirdDrawnFrequency + ", fourthDrawnFrequency="
				+ fourthDrawnFrequency + ", fifthDrawnFrequency="
				+ fifthDrawnFrequency + "]";
	}
}
