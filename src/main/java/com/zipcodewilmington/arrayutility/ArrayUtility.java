package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] utitltyArray;
    public ArrayUtility(T[] inputArray) {
        this.utitltyArray = inputArray;
    }

    public void mergeArray(T[] arrayToMerge){
        T[] newArray = Arrays.copyOf(utitltyArray,utitltyArray.length+arrayToMerge.length);
        int j = 0;
        for(int i = utitltyArray.length; i < newArray.length; i++){
            newArray[i] = arrayToMerge[j];
            j++;
        }
        utitltyArray = newArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        mergeArray(arrayToMerge);
        Integer mostCommonDup = 0;
        for(T thing : utitltyArray){
            if(getNumberOfOccurrences(thing)>mostCommonDup){
                mostCommonDup = getNumberOfOccurrences(thing);
            }
        }
        return mostCommonDup;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        mergeArray(arrayToMerge);
        T mostCommon = null;
        int mostCommonCount = 0;
        for(T thing:utitltyArray){
            if(getNumberOfOccurrences(thing)>mostCommonCount){
                mostCommon = thing;
                mostCommonCount = getNumberOfOccurrences(thing);
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
            Integer count = 0;

        for(T thing:utitltyArray){
                if(thing.equals(valueToEvaluate)){
                    count++;
                }
            }

        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] newArray = Arrays.copyOf(utitltyArray,utitltyArray.length-getNumberOfOccurrences(valueToRemove));
        int j = 0;
        for (int i = 0; i < utitltyArray.length; i++) {
            if(!utitltyArray[i].equals(valueToRemove)){
                newArray[j] = utitltyArray[i];
                j++;
            }
        }

        return newArray;
    }


}
