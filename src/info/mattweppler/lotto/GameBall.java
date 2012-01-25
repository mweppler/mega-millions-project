package info.mattweppler.lotto;

public class GameBall
{
	protected int label;
	protected int drawnFrequency;
	public GameBall()
	{
		
	}
	public GameBall(int l)
	{
		label = l;
	}
	public GameBall(int l, int df)
	{
		label = l;
		drawnFrequency = df;
	}
	public int getLabel()
	{
		return label;
	}
	public int getDrawnFrequency()
	{
		return drawnFrequency;
	}
	public void setLabel(int label)
	{
		this.label = label;
	}
	public void setDrawnFrequency(int drawnFrequency)
	{
		this.drawnFrequency = drawnFrequency;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof GameBall)) return false;
		GameBall that = (GameBall) obj;
		return this.getLabel() == that.getLabel();
	}
	@Override
	public int hashCode()
	{
		int hash = 3;
		hash = 97 * hash + this.label;
		return hash;
	}
	@Override
	public String toString()
	{
		return "GameBall [label=" + label + ", drawnFrequency="
				+ drawnFrequency + "]";
	}
}
