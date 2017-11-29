package com.esof322.pa2.model;

import java.util.List;

public class Board {

	private Space[] spaces;
	private PropertyGroup[] propertyGroups;
	private Banker banker;
	private int[] rates;

	public Board(Banker banker) {
		this.banker = banker;
		this.spaces = new Space[40];
		init();
	}

	public Space getSpace(int pos) {
		return this.spaces[pos];
	}

	public PropertyGroup getGroup(int i) {
		return this.propertyGroups[i];
	}

	public int[] tempReplaceRR(int a, int b, int c, int d, int e) {
		temp = new int[] {a, b, c, d, e};
		return temp;

	}
	public int[] tempReplaceU(int a) {
		temp = new int[] {a};
		return temp;
	}
	private void init() {
		spaces[0] = new BlankSpace("Go");
		
		rates = new int[] {2,10,30,90,160,250};
		spaces[1] = new PropertySpace(banker, 
				"Mediterranean Avenue",propertyGroups[0], 60, 50, rates);
		
		spaces[2] = new BlankSpace("Community Chest");
		
		rates = new int[] {4,20,60,180,320,450};
		spaces[3] = new PropertySpace(banker, 
				"Baltic Avenue", propertyGroups[0], 60, 50, rates);
		
		spaces[4] = new TaxSpace("Income Tax",true);
		
		tempReplaceRR(200,25,50,100,200);
		spaces[5] = new Railroad("Reading Railroad", temp);
		
		rates = new int[] {6,30,90,270,400,550};
		spaces[6] = new PropertySpace(banker, 
				"Oriental Avenue", propertyGroups[1], 100, 50, rates);
		
		spaces[7] = new BlankSpace("Chance");
		
		rates = new int[] {6,10,90,270,400,550};
		spaces[8] = new PropertySpace(banker, 
				"Vermont Avenue", propertyGroups[1], 100, 50, rates);
		
		rates = new int[] {8,40,100,300,450,600};
		spaces[9] = new PropertySpace(banker, 
				"Connecticut Avenue", propertyGroups[1], 120, 50, rates);
		
		spaces[10] = new BlankSpace("Just Visiting");
		
		rates = new int[] {10,50,150,450,625,750};
		spaces[11] = new PropertySpace(banker, 
				"St. Charles Place", propertyGroups[2], 140, 50, rates);
		
		tempReplaceU(150);
		spaces[12] = new Utility("Electric Company", temp);
		
		rates = new int[] {10,50,150,450,625,750};
		spaces[13] = new PropertySpace(banker, 
				"States Avenue", propertyGroups[2], 140, 50, rates);
		
		rates = new int[] {12,60,180,500,700,900};
		spaces[14] = new PropertySpace(banker, 
				"Virginia Avenue", propertyGroups[2], 160, 50, rates);
		
		tempReplaceRR(200,25,50,100,200);
		spaces[15] = new Railroad("Pennsylvania Railroad", temp);
		
		rates = new int[] {14,70,200,550,750,950};
		spaces[16] = new PropertySpace(banker, 
				"St. James Place", propertyGroups[3], 180, 50, rates);
		
		spaces[17] = new BlankSpace("Community Chest");
		
		rates =  new int[] {14,70,200,550,750,950};
		spaces[18] = new PropertySpace(banker, 
				"Tennessee Avenue", propertyGroups[3], 180, 50, rates);
		
		rates = new int[] {16,80,220,600,800,1000};
		spaces[19] = new PropertySpace(banker, 
				"New York Avenue", propertyGroups[3], 200, 50, rates);
		
		spaces[20] = new BlankSpace("Free Parking");
		
		rates = new int[] {18,90,250,700,875,1050};
		spaces[21] = new PropertySpace(banker, 
				"Kentucky Avenue", propertyGroups[4], 220, 50, rates);
		
		spaces[22] = new BlankSpace("Chance");
		
		rates = new int[] {19,90,250,700,875,1050};	
		spaces[23] = new PropertySpace(banker, 
				"Indiana Avenue", propertyGroups[4], 220, 50, rates);
		
		rates = new int[] {20,100,300,750,925,1100};
		spaces[24] = new PropertySpace(banker, 
				"Illinois Avenue", propertyGroups[4], 240, 50, rates);
		
		tempReplaceRR(200,25,50,100,200);
		spaces[25] = new Railroad("B&O Railroad", temp);
		
		rates = new int[] {22,110,330,800,975,1150};
		spaces[26] = new PropertySpace(banker, 
				"Atlantic Avenue", propertyGroups[5], 260, 50, rates);
		
		rates = new int[] {22,110,330,800,975,1150};
		spaces[27] = new PropertySpace(banker, 
				"Ventnor Avenue", propertyGroups[5], 260, 50, rates);
		
		tempReplaceU(150);
		spaces[28] = new Utility("Water Works", temp);
		
		rates = new int[] {24,120,360,850,1025,1200};
		spaces[29] = new PropertySpace(banker, 
				"Marvin Gardens", propertyGroups[5], 280, 50, rates);
		
		spaces[30] = new GotoJailSpace("Go to Jail");
		
		rates = new int[] {26,130,390,900,1100,1275};
		spaces[31] = new PropertySpace(banker, 
				"Pacific Avenue", propertyGroups[6], 300, 50, rates);
		
		rates = new int[] {26,130,390,900,1100,1275};
		spaces[32] = new PropertySpace(banker, 
				"North Carolina Avenue", propertyGroups[6], 300, 50, rates);
		
		spaces[33] = new BlankSpace("Community Chest");
		
		rates = new int[] {28,150,450,1000,1200,1400};
		spaces[34] = new PropertySpace(banker, 
				"Pennsylvania Avenue", propertyGroups[6], 320, 50, rates);
		
		tempReplaceRR(200,25,50,100,200);
		spaces[35] = new Railroad("Short Line", temp);
		
		spaces[36] = new BlankSpace("Chance");
		
		rates = new int[] {35,175,500,1100,1300,1500};
		spaces[37] = new PropertySpace(banker, 
				"Park Place", propertyGroups[5], 350, 50, rates);
		
		spaces[38] = new TaxSpace("Luxury Tax",false);
		
		rates = new int[] {50,200,600,1400,1700,2000};
		spaces[39] = new PropertySpace(banker, 
				"Boardwalk", propertyGroups[5], 400, 50, rates);
		
	}

}
