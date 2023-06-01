package misc;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class main_misc2 {
	
   
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
		int[] v = {170,45,75,90,802,24,2,66};
		//int[] v = {2,1,5,6,3,4,7,8,9};
		radix_sort(v);
		for(int i = 0;i < v.length;i++) {
			System.out.print(v[i]+" ");
		}
		
	}	
	
	
	
	private static int get_max(int[] v){
		
		int max = 0;
		for(int i = 0;i < v.length;i++){
			if(v[i] >= max) {
				max = v[i];
			}
		}
		return max;
	}
	
	private static int[] radix_sort(int[] v){
		
		int max = get_max(v);
		
		for(int div = 1;(max/div) > 0;div *= 10){//this loop will count the number o digits of max
			queue_step(v,div);
		}
		return v;
		
	}
	private static void queue_step(int[] v,int div){
		
		//Sort the array based on a specific digit give by div
		
		
		//create a queue for each digit
		HashMap<Integer,LinkedList<Integer>> queues = new HashMap<>();
		
		//creating the queues
		for(int i = 0;i <= 9;i++){
			queues.put(i, new LinkedList<>());
			
		}
		
		//queue:addFirst and removeLast or addLast and removeFirst
		
		for(int i = 0;i < v.length;i++) {
			
			int digit = (v[i]/div)%10;
			queues.get(digit).addFirst(v[i]);
			
		}
		
		//passing the values from the queues to v
		int c = 0;
		for(int i = 0;i <= 9;i++){//O(9n) --> O(n)
			
			while(!queues.get(i).isEmpty()){
				v[c] = queues.get(i).removeLast();
				c++;
			}
			
		}
		
		
	}
	
	
	} 
	
