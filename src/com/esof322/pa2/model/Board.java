package com.esof322.pa2.model;

import java.util.List;

public class Board {

	private Board b;
	private Space[] spaces;
	private PropertyGroup colors;

	public Board() {
		this.spaces = new Space[40];
		this.b = this;
		init();
	}

	public Space getSpace(int pos) {
		return this.spaces[pos];
	}

	public PropertyGroup getGroups() {
		return this.colors;
	}

	private int[] temp;
	public int[] tempReplace(int a, int b, int c, int d, int e, int f, int g) {
		temp = new int[] {a, b, c, d, e, f, g}; 
		return temp;
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
		BlankSpace blankSpace;
		TaxSpace tax;
		JailSpace jail;
		GotoJailSpace goToJail;
		PropertySpace prop;
		Railroad rail;
		Utility util;
		spaces[0] = new BlankSpace("Go");
		tempReplace(60,2,10,30,90,160,250);
		spaces[1] = new PropertySpace("Mediterranean Avenue", temp);
		spaces[2] = new BlankSpace("Community Chest");
		tempReplace(60,4,20,60,180,320,450);
		spaces[3] = new PropertySpace("Baltic Avenue", temp);
		spaces[4] = new TaxSpace("Income Tax",true);
		tempReplaceRR(200,25,50,100,200);
		spaces[5] = new Railroad("Reading Railroad", temp);
		tempReplace(100,6,30,90,270,400,550);
		spaces[6] = new PropertySpace("Oriental Avenue", temp);
		spaces[7] = new BlankSpace("Chance");
		tempReplace(100,6,10,90,270,400,550);
		spaces[8] = new PropertySpace("Vermont Avenue", temp);
		tempReplace(120,8,40,100,300,450,600);
		spaces[9] = new PropertySpace("Connecticut Avenue", temp);
		spaces[10] = new JailSpace("In Jail/Just Visiting");
		tempReplace(140,10,50,150,450,625,750);
		spaces[11] = new PropertySpace("St. Charles Place", temp);
		tempReplaceU(150);
		spaces[12] = new Utility("Electric Company", temp);
		tempReplace(140,10,50,150,450,625,750);
		spaces[13] = new PropertySpace("States Avenue", temp);
		tempReplace(160,12,60,180,500,700,900);
		spaces[14] = new PropertySpace("Virginia Avenue", temp);
		tempReplaceRR(200,25,50,100,200);
		spaces[15] = new Railroad("Pennsylvania Railroad", temp);
		tempReplace(180,14,70,200,550,750,950);
		spaces[16] = new PropertySpace("St. James Place", temp);
		spaces[17] = new BlankSpace("Community Chest");
		tempReplace(180,14,70,200,550,750,950);
		spaces[18] = new PropertySpace("Tennessee Avenue", temp);
		tempReplace(200,16,80,220,600,800,1000);
		spaces[19] = new PropertySpace("New York Avenue", temp);
		spaces[20] = new BlankSpace("Free Parking");
		tempReplace(220,18,90,250,700,875,1050);
		spaces[21] = new PropertySpace("Kentucky Avenue", temp);
		spaces[22] = new BlankSpace("Chance");
		tempReplace(220,19,90,250,700,875,1050);
		spaces[23] = new PropertySpace("Indiana Avenue", temp);
		tempReplace(240,20,100,300,750,925,1100);
		spaces[24] = new PropertySpace("Illinois Avenue", temp);
		tempReplaceRR(200,25,50,100,200);
		spaces[25] = new Railroad("B&O Railroad", temp);
		tempReplace(260,22,110,330,800,975,1150);
		spaces[26] = new PropertySpace("Atlantic Avenue", temp);
		tempReplace(260,22,110,330,800,975,1150);
		spaces[27] = new PropertySpace("Ventnor Avenue", temp);
		tempReplaceU(150);
		spaces[28] = new Utility("Water Works", temp);
		tempReplace(280,24,120,360,850,1025,1200);
		spaces[29] = new PropertySpace("Marvin Gardens", temp);
		spaces[30] = new GotoJailSpace("Go to Jail");
		tempReplace(300,26,130,390,900,1100,1275);
		spaces[31] = new PropertySpace("Pacific Avenue", temp);
		tempReplace(300,26,130,390,900,1100,1275);
		spaces[32] = new PropertySpace("North Carolina Avenue", temp);
		spaces[33] = new BlankSpace("Community Chest");
		tempReplace(320,28,150,450,1000,1200,1400);
		spaces[34] = new PropertySpace("Pennsylvania Avenue", temp);
		tempReplaceRR(200,25,50,100,200);
		spaces[35] = new Railroad("Short Line", temp);
		spaces[36] = new BlankSpace("Chance");
		tempReplace(350,35,175,500,1100,1300,1500);
		spaces[37] = new PropertySpace("Park Place", temp);
		spaces[38] = new TaxSpace("Luxury Tax",false);
		tempReplace(400,50,200,600,1400,1700,2000);
		spaces[39] = new PropertySpace("Boardwalk", temp);
		this.colors = new PropertyGroup(spaces);
	}

}
