/*
 * 
 */
package info.mattweppler.lotto;

import info.mattweppler.fileutils.FileUtils;

import java.io.File;
import java.util.ArrayList;

public class ParseLottoResultsFile
{
    public static ArrayList<MegaMillionsGame> parseLottoResultsFileReturnArrayList()
    {
        ArrayList<MegaMillionsGame> mmgList = new ArrayList<MegaMillionsGame>();
        //for (String string : FileUtils.readFileByLine(FileUtils.openFileDialog())) {
        for (String string : FileUtils.readFileByLine(new File("/Users/mattweppler/developer/projects/lotto/calottoresults.csv"))) {
            String[] result = string.split("\\,");
            MegaMillionsGame mmg = new MegaMillionsGame();
            mmg.setDrawNumber(Integer.parseInt(result[0]));
            mmg.setDrawDate(result[1]);
            int[] winningNumbers = {
                Integer.parseInt(result[2]),
                Integer.parseInt(result[3]),
                Integer.parseInt(result[4]),
                Integer.parseInt(result[5]),
                Integer.parseInt(result[6])
            };
            mmg.setWinningNumbers(winningNumbers);
            mmg.setMegaNumber(Integer.parseInt(result[7]));
            mmgList.add(mmg);
        }
        return mmgList;
    }
}
