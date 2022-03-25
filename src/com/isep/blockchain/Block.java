package com.isep.blockchain;

import java.util.ArrayList;

/**
 * Class Block
 */
public class Block {

    //
    // Fields
    //
    public ArrayList<Transaction> transactions;

    //
    // Constructors
    //
    public Block(){
        this.transactions = new ArrayList<>();
    }

    //
    // Methods
    //
    public int addTransaction(Wallet originWallet, Wallet destinationWallet, int isepCoins){
        if (this.transactions.size() < 10){
            this.transactions.add(new Transaction(originWallet, destinationWallet, isepCoins));
            return 0;
        } else {
            for (int i = 0; i < this.transactions.size(); ++i) {
                this.transactions.get(i).processTransaction();
            }
            return 1;
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
