package com.and.test;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	//I have made Junit test classes to test my implementation works under test class

    public static String solution(String input) throws NumberFormatException {
    	
    	//The final value to be returned
    	StringBuilder answer = new StringBuilder();
    	
    	//Initialise an Array list which will contain all the integers in the input string
    	ArrayList<Integer> eachInteger = new ArrayList<Integer>();
    	
    	//Initialise a Character Array with length of the input string, we will iterate through this and append the array list eachInteger with
    	//integer contained in eachCharacter array
    	char[] eachCharacter = new char[input.length()];
    	eachCharacter = input.toCharArray();
    	for (char c : eachCharacter) {
			try {
				String s = String.valueOf(c);
				int currentInt = Integer.parseInt(s);
				eachInteger.add(currentInt);
			} catch (Exception e) {
				continue;
			}
		}
    	//Throws exception if input string does not contain any integers 
    	if (eachInteger.isEmpty()) {
    		throw new NumberFormatException("This String Has No Integers!");
			
		}
    	
    	//Calls the method allCombinations with the arrayList of Integers and returns ArrayList<ArrayList<Integer>>
    	ArrayList<ArrayList<Integer>> intCombinations = allCombinations(eachInteger);
    	
    	//andCouples will hold the unsorted list of integers for example [326, 236, 632 etc]
    	ArrayList<String> andCouples = new ArrayList<String>();
    	
    	//StringBuilder s gets the individual andCouple  and adds to the andCouples arrayList
    	for (ArrayList<Integer> arrayList : intCombinations) {
    		StringBuilder s = new StringBuilder();
			for (int integer : arrayList) {
				s.append(integer);
			}
			andCouples.add(s.toString());
		}
			
    	//Sorts the andCouples in descending order
    	Collections.sort(andCouples,Collections.reverseOrder());
    	for (String string : andCouples) {
			answer.append(string+",");
		}
    	answer.replace(answer.length()-1, answer.length(), "");
    	
    	System.out.println(answer);
        return answer.toString();
        
    }
    
    //This method generates all combinations of the numbers The first call includes the current element. The second call discards the current element.
    public static ArrayList<ArrayList<Integer>> allCombinations(ArrayList<Integer> list){
    	//Base Case
    	if(list.size()==0) {
    		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    		result.add(new ArrayList<Integer>());
    		return result;
    	}
    	
    	ArrayList<ArrayList<Integer>> resultReturn = new ArrayList<ArrayList<Integer>>();
    	Integer firstElement = list.remove(0);
    	
    	ArrayList<ArrayList<Integer>> recursiveReturn = allCombinations(list);
    	for (ArrayList<Integer> arrayList : recursiveReturn) {
			for (int i = 0; i <= arrayList.size(); i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(arrayList);
				temp.add(i, firstElement);
				resultReturn.add(temp);
				
			}
		}
		return resultReturn;
    }

    public static void main(String args[]) {
        solution("326");
        System.out.println("Another Test: ");
        solution("A 3B2 C6D");
//        System.out.println("Another Test: ");
//        solution("ABC");
    }

}
