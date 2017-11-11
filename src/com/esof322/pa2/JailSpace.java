package com.esof322.pa2;


/**
* @generated
*/
public class JailSpace extends Space {
    
	public JailSpace(String name) {
    	setName(name);
    }
	
	public String getNameSpace() {
		return getName();
	}

	@Override
	void takeAction(Player callingPlayer) {
		if (callingPlayer.getJailed() == true) {
			System.out.println("Choose to roll doubles or pay $50"); //Eventually change this to prompt with buttons 
			
				Die die1 = new Die();
				Die die2 = new Die();
				int iter = 0;
				die1.rollDie();
				die2.rollDie();
				for(int i = 1; i <= 0; i--) {

					if(die1.getValue()==die2.getValue()) {
						i++; 
						iter++;
					}
					else {
						i = 0;
					}
					if(iter >= 3) {
						callingPlayer.removeJailedStatus();
					}
				}
				// TODO Auto-generated method stub
			}
		}


}
