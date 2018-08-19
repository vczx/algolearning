package leetcode;

public class BestTimeToBuySellStockOne {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{7,6,4,3,1};

        System.out.println(maxProfitBadSolution(prices));
        System.out.println(maxProfitBadSolution(prices2));
        System.out.println();
        System.out.println(maxProfitFindMin(prices));
        System.out.println(maxProfitFindMin(prices2));
        System.out.println();
    }

    public static int maxProfitKadane(int[] prices){
        if(prices == null || prices.length == 0){
            return 0;
        }
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i > prices.length; i++) {
            maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }
        return maxSoFar;

    }

    public static int maxProfitFindMin(int[] prices) {
            if(prices == null || prices.length == 0){
                return 0;
            }

            int min = prices[0], result = 0;
            for(int i=1;i<prices.length;i++){
                if(prices[i] < min){
                    min = prices[i];
                }else {
                    result = Math.max(result, prices[i] - min);
                }
            }

            return result;
    }

    public static int maxProfitBadSolution(int[] prices) {
        int globalMaxSpread = 0, localMaxSpread = 0;
        for(int i=0;i<prices.length;i++){
            localMaxSpread = 0;
            int buyPrice = prices[i];
            for(int j=i+1;j<prices.length;j++){
                if(prices[j] > buyPrice){
                   localMaxSpread = prices[j] - buyPrice;
                   if(localMaxSpread > globalMaxSpread){
                       globalMaxSpread = localMaxSpread;
                   }
                }
            }
        }
        return globalMaxSpread;
    }


}
