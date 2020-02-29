package com.sriman.mavenoop;

/**
 * Hello world!
 *
 */
import java.io.*;
import java.util.*;
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        List<Sweet> list_of_sweets = new ArrayList<Sweet>();
        list_of_sweets.add(new Chocolate("DairyMilk",180,200.0f,62));
        list_of_sweets.add(new Chocolate("KitKat",20,50.5f,50));
        list_of_sweets.add(new Chocolate("MilkyBar",10,20.4f,40));
        list_of_sweets.add(new Chocolate("FerreroRocher",200,180.7f,75));
        list_of_sweets.add(new Jelly("JustJelly",30,20.6f,25));
        list_of_sweets.add(new Jelly("JollyRancher",20,15.6f,20));
        list_of_sweets.add(new Jelly("JellyBelly",50,20.6f,65));
        list_of_sweets.add(new Candy("Hershey's Kisses",60,8.1f,90));
		list_of_sweets.add(new Candy("LaffyTaffy",90,30.1f,75));
		list_of_sweets.add(new Candy("Nerds",10,2.6f,10));
		list_of_sweets.add(new Candy("MilkyWay",30,15.6f,25));
		list_of_sweets.add(new Candy("DoubleBubbleGum",5,3.0f,15));
		
		List<Sweet> list_of_chocolates = new ArrayList<>();
		float totalWeight=0.0f;
		for(int i=0;i<list_of_sweets.size();i++) {
			totalWeight+=list_of_sweets.get(i).weight;
		}
		System.out.println("Total weight of Gift is :"+totalWeight);
		for(int i=0;i<list_of_sweets.size();i++) {
			if(list_of_sweets.get(i) instanceof Chocolate) {
				list_of_chocolates.add(list_of_sweets.get(i));
			}
		}
		System.out.print("Enter the Option :\n1.sortByCost\n2.sortByWeight\n3.sortBySweetness\n4.don't sort\n");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				Collections.sort(list_of_chocolates,(a,b)->a.cost-b.cost);
				break;
			case 2:
				Collections.sort(list_of_chocolates,(a,b)->Float.compare(a.weight,b.weight));
				break;
			case 3:
				Collections.sort(list_of_chocolates,(a,b)->a.sweetness-b.sweetness);
				break;
		}
		System.out.println("Chocolates Present in the Gift are:");
		System.out.printf("\n%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
		for(int i=0;i<list_of_chocolates.size();i++){
			System.out.printf("%-15s %3d %8.4f %6d\n\n",list_of_chocolates.get(i).name,list_of_chocolates.get(i).cost,list_of_chocolates.get(i).weight,list_of_chocolates.get(i).sweetness);
			
		}
		System.out.println("Do you Want List of Candies(y/n)");
		char c=sc.next().charAt(0);
		if(c=='y'||c=='Y'){
			System.out.print("Enter the Option :\n1.Cost\n2.Weight\n3.Sweetness\n");
			choice=sc.nextInt();
			System.out.println("Enter the Range");
			int min=sc.nextInt();
			int max=sc.nextInt();
			System.out.printf("%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
			Sweet curr;
			int f=0;
			if(choice==1) {
				for(int i=0;i<list_of_sweets.size();i++) {
					curr=list_of_sweets.get(i);
					if(curr instanceof Candy && curr.cost>=min && curr.cost<=max){
						f=1;
						System.out.printf("%-15s %3d %8.2f %6d\n\n",curr.name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with cost of given range is not available");
			}
			else if(choice==2) {
				for(int i=0;i<list_of_sweets.size();i++) {
					curr=list_of_sweets.get(i);
					if(curr instanceof Candy && curr.weight>=min && curr.weight<=max){
						f=1;
						System.out.printf("%-15s %3d %8.4f %6d\n\n",curr.name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with weight of given range is not available");
			}
			else {
				for(int i=0;i<list_of_sweets.size();i++) {
					curr=list_of_sweets.get(i);
					if(curr instanceof Candy && curr.sweetness>=min && curr.sweetness<=max){
						f=1;
						System.out.printf("%-15s %3d %8.4f %6d\n\n",curr.name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with sweetness of given range is not available");
			}
		}
		sc.close();
    }

}
