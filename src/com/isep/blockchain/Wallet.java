package com.isep.blockchain;

import java.security.*;

/**
 * Class Wallet
 */
public class Wallet {

    //
    // Fields
    //
    public final String owner;
    public final int token;
    public int isepCoins;

    //
    // Constructors
    //
    public Wallet(String owner){
        this.owner = owner;
        this.token = generateToken();
        this.isepCoins = 0;
    }

    //
    // Methods
    //
    public int generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(999999999);
    }

    public String getOwner() {
        return owner;
    }

    public int getIsepCoins() {
        return isepCoins;
    }

    public void setIsepCoins(int isepCoins) {
        this.isepCoins = isepCoins;
    }

}
