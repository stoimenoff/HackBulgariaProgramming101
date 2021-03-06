package week03.Statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by georgipavlov on 03.12.15.
 */

// Get a DescriptiveStatistics instance
//DescriptiveStatistics stats = new DescriptiveStatistics();

// Add the data from the array
       // for( int i = 0; i < inputArray.length; i++) {
       // stats.addValue(inputArray[i]);
      //  }

// Compute some statistics
       // double mean = stats.getMean();
       // double std = stats.getStandardDeviation();
       // double median = stats.getPercentile(50);


public class Statistics implements StatisticsInterfaceWithAdd {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private int sum = 0;
    @Override
    public int getMean() {
        return sum/numbers.size();
    }

    @Override
    public int getMedian() {
        int index = (arrayList.size()+1)/2;
        return numbers.get(index);
    }

    @Override
    public int getMode() {
        Map<Integer,Integer> map = new HashMap<>();
        Integer count;
        for(Integer e:numbers){
            count = map.get(e);
            if(count == null){
                count = 0;
            }
            count++;
            map.put(e,count);
        }
        int tempValue=0;
        for(Map.Entry<Integer,Integer> mapE: map.entrySet()){
            if(tempValue < mapE.getValue()){
                tempValue = mapE.getValue();
            }
        }
        return tempValue;
    }

    @Override
    public int getRange() {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i <numbers.size() ; i++) {
            ts.add(numbers.get(i));
        }
        return ts.last() - ts.first();
    }

    @Override
    public void add(int number) {
    	numbers.add(number);
        Collections.sort(numbers);
        sum += number;
    }

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        statistics.add(2);
        statistics.add(5);
        statistics.add(2);
        statistics.add(8);
        statistics.add(2);
        statistics.add(9);
        statistics.add(1);
        statistics.add(2);
        System.out.println(statistics.getRange());

    }
}



