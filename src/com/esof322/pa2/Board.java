package com.esof322.pa2;

import java.util.List;

public class Board {
    
    private List<Space> spaces;
    private Banker banker;
    
    protected Space getSpace(int pos) {
    		return spaces.get(pos);
    }
    
    
}
//