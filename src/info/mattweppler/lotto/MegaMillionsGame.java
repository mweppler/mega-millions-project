/*
 * How to Play:
 * 
 * Mark five numbers from 1 to 56 and a MEGA number from 1 to 46 for each play.
 */
package info.mattweppler.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

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

    public static void retrieveIncrementedSortedResults(ArrayList<MegaMillionsGame> mmgList)
    {
        HashMap<Integer, Integer> winningNumbers = new HashMap<Integer, Integer>();
        for (int i=1;i<57;i++) {
            winningNumbers.put(i, 0);
        }
        HashMap<Integer, Integer> megaNumbers = new HashMap<Integer, Integer>();
        for (int i=1;i<47;i++) {
            megaNumbers.put(i, 0);
        }
        for (MegaMillionsGame mmg : mmgList) {
            for (int i : mmg.getWinningNumbers()) {
                if (winningNumbers.containsKey(i)) {
                    winningNumbers.put(i, winningNumbers.get(i).intValue() + 1);
                }
            }
            megaNumbers.put(mmg.getMegaNumber(), megaNumbers.get(mmg.getMegaNumber()).intValue() + 1);
        }
        
        HashMap<Integer, Integer> winningNumbersSorted = new HashMap<Integer, Integer>();
        winningNumbersSorted = sortHashMap(winningNumbers, "DESC");
        
        HashMap<Integer, Integer> megaNumbersSorted = new HashMap<Integer, Integer>();
        megaNumbersSorted = sortHashMap(megaNumbers, "DESC");
        
        System.out.println("Winning Numbers:");
        for (Integer number : winningNumbersSorted.keySet()){
            System.out.println("\t"+number+" "+winningNumbersSorted.get(number));
        }
        
        System.out.println("Mega Numbers:");
        for (Integer number : megaNumbersSorted.keySet()){
            System.out.println("\t"+number+" "+megaNumbersSorted.get(number));
        }
    }
    
    /**
     * 
     * @param input
     * @param order "ASC" or "DESC"
     * @return
     */
    private static HashMap<Integer, Integer> sortHashMap(HashMap<Integer, Integer> input, String order){
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for (int i : input.keySet()){
            tempMap.put(i, input.get(i));
        }

        List<Integer> mapKeys = new ArrayList<Integer>(tempMap.keySet());
        List<Integer> mapValues = new ArrayList<Integer>(tempMap.values());
        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(mapValues);
        Object[] sortedArray = sortedSet.toArray();
        if (order.equals("ASC")) {
            for (int i=0; i<sortedArray.length; i++){
                sortedMap.put(mapKeys.get(mapValues.indexOf(sortedArray[i])), 
                              (Integer)sortedArray[i]);
            }
        } else if (order.equals("DESC")) {
            for (int i=sortedArray.length; i>0; i--){
                sortedMap.put(mapKeys.get(mapValues.indexOf(sortedArray[i-1])), 
                              (Integer)sortedArray[i-1]);
            }
        }
        return sortedMap;
    }
    
}