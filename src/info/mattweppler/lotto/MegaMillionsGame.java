/*
 * How to Play:
 * 
 * Mark five numbers from 1 to 56 and a MEGA number from 1 to 46 for each play.
 */
package info.mattweppler.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MegaMillionsGame
{
    private int   drawNumber;
    private String  drawDate;
    private int[] winningNumbers;
    private int   megaNumber;
    
    public MegaMillionsGame()
    {
        // Empty constructor
    }
    
    public int getDrawNumber()
    {
        return drawNumber;
    }
    
    public String getDrawDate()
    {
        return drawDate;
    }
    
    public int[] getWinningNumbers()
    {
        return winningNumbers;
    }
    
    public int getMegaNumber()
    {
        return megaNumber;
    }
    
    public void setDrawNumber(int drawNumber)
    {
        this.drawNumber = drawNumber;
    }
    
    public void setDrawDate(String drawDate)
    {
        this.drawDate = drawDate;
    }
    
    public void setWinningNumbers(int[] winningNumbers)
    {
        this.winningNumbers = winningNumbers;
    }
    
    public void setMegaNumber(int megaNumber)
    {
        this.megaNumber = megaNumber;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("MegaMillionsGame [drawNumber=");
        builder.append(drawNumber);
        builder.append(", ");
        if (drawDate != null) {
            builder.append("drawDate=");
            builder.append(drawDate);
            builder.append(", ");
        }
        if (winningNumbers != null) {
            builder.append("winningNumbers=");
            builder.append(Arrays.toString(winningNumbers));
            builder.append(", ");
        }
        builder.append("megaNumber=");
        builder.append(megaNumber);
        builder.append("]");
        return builder.toString();
    }

    private static void setGameBall(int i, ArrayList<GameBall> gb)
    {
    	GameBall testGameBall = new GameBall(i);
    	if (gb.contains(testGameBall)) {
    		testGameBall = gb.get(gb.indexOf(testGameBall));
    		testGameBall.setDrawnFrequency(testGameBall.getDrawnFrequency() + 1);
        } else {
            testGameBall.setDrawnFrequency(1);
            gb.add(testGameBall);
        }
    }
    public static void retrieveIncrementedSortedResults(ArrayList<MegaMillionsGame> mmgList)
    {
    	ArrayList<GameBall> winningNumbers = new ArrayList<GameBall>();
    	ArrayList<GameBall> megaNumbers = new ArrayList<GameBall>();
        for (MegaMillionsGame mmg : mmgList) {
            for (int i : mmg.getWinningNumbers()) {
            	setGameBall(i, winningNumbers);
            }
            setGameBall(mmg.getMegaNumber(), megaNumbers);
        }
//        String sortBy = "label";
        String sortBy = "frequency";
        if (sortBy.equals("label")) {
        	Collections.sort(winningNumbers, new LabelComparison());
            Collections.sort(megaNumbers, new LabelComparison());
        } else {
        	Collections.sort(winningNumbers, new FrequencyComparison());
        	Collections.sort(megaNumbers, new FrequencyComparison());
        }
        System.out.println("Winning Numbers:");
        System.out.println("\tNumber\tFrequency");
        for (GameBall gameBall : winningNumbers){
            System.out.printf("\t%2d\t%2d\n", gameBall.getLabel(), gameBall.getDrawnFrequency());
        }
        System.out.println("\nMega Numbers:");
        System.out.println("\tNumber\tFrequency");
        for (GameBall gameBall : megaNumbers){
        	System.out.printf("\t%2d\t%2d\n", gameBall.getLabel(), gameBall.getDrawnFrequency());
        }
    }
    public static class LabelComparison implements Comparator<GameBall> {
        @Override
        public int compare(GameBall gb1, GameBall gb2) {
        	Integer tmp1 = (Integer) gb1.getLabel();
        	Integer tmp2 = (Integer) gb2.getLabel();
            return tmp1.compareTo(tmp2);
        }
    }    
    public static class FrequencyComparison implements Comparator<GameBall> {
        @Override
        public int compare(GameBall gb1, GameBall gb2) {
        	Integer tmp1 = (Integer) gb1.getDrawnFrequency();
        	Integer tmp2 = (Integer) gb2.getDrawnFrequency();
            return tmp2.compareTo(tmp1);
        }
    }
}