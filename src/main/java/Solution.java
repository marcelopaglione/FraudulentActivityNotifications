public class Solution {

    private static int[] medianArray;
    private static float calcMedianOdd(int[] queue, int from, int to, int nthElement) {
        int i = 0;
        int currentSumOfPositions = -1; //zero will be the first found position, so start it with -1

        if(from==0) {
            for (int j = from; j <= to; j++) {
                medianArray[queue[j]]++;
            }
        }else{
            medianArray[queue[to]]++;
            medianArray[queue[from-1]]--;
        }

        while (currentSumOfPositions < nthElement - medianArray[i]) {
            currentSumOfPositions += medianArray[i];
            i++;
        }
        return i;
    }

    private static float calcMedianEven(int[] queue, int from, int to, int nthElement) {
        int i = 0;
        float median1;
        int currentSumOfPositions = -1; //zero will be the first found position, so start it with -1

        if(from==0) {
            for (int j = from; j <= to; j++) {
                medianArray[queue[j]]++;
            }
        }else{
            medianArray[queue[to]]++;
            medianArray[queue[from-1]]--;
        }

        while (currentSumOfPositions < nthElement - medianArray[i]) {
            currentSumOfPositions += medianArray[i];
            i++;
        }
        nthElement++;
        median1 = i;
        while (currentSumOfPositions < nthElement - medianArray[i]) {
            currentSumOfPositions += medianArray[i];
            i++;
        }
        return (median1 + i) / (float) 2;
    }

    public static int activityNotifications(int[] expenditure, int d) {
        medianArray = new int[201];
        int totalNotification = 0;

        float median;

        int medianIndex;

        int from = 0; // 1st index of range
        int to = d - 1; // last index of range

        if (d % 2 == 0) { // even
            medianIndex = (d - 1) / 2;
            // Calc median for each range
            for (int currentItem = d; currentItem < expenditure.length; currentItem++) {
                median = calcMedianEven(expenditure, from, to, medianIndex);

                if (expenditure[currentItem] >= (2 * median)) {
                    totalNotification++;
                }

                from++;
                to++;
            }
        } else { // odd
            medianIndex = (d) / 2;
            // Calc median for each range
            for (int currentItem = d; currentItem < expenditure.length; currentItem++) {
                median = calcMedianOdd(expenditure, from, to, medianIndex);
                if (expenditure[currentItem] >= (2 * median)) {
                    totalNotification++;
                }
                from++;
                to++;
            }
        }

        return totalNotification;
    }


}
