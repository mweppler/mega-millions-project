/*
 * Java App : Lotto Numbers...
 */
package info.mattweppler.lotto;
 
public class Lotto
{
    public static void main(String[] args)
    {
        MegaMillionsGame.retrieveIncrementedSortedResults(ParseLottoResultsFile.parseLottoResultsFileReturnArrayList());
        System.exit(0);
    }
}