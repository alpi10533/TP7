package com.isep.blockchain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Class Transaction
 */
public class Transaction {

    //
    // Fields
    //
    public final Wallet originWallet;
    public final Wallet destinationWallet;
    public final int isepCoins;
    public String payed;

    //
    // Constructors
    //
    public Transaction(Wallet originWallet, Wallet destinationWallet, int isepCoins){
        this.originWallet = originWallet;
        this.destinationWallet = destinationWallet;
        this.isepCoins = isepCoins;
        this.payed = "";
    }

    //
    // Methods
    //
    public void processTransaction(){
        if (this.originWallet != this.destinationWallet){
            if (this.originWallet.getIsepCoins() - this.isepCoins >= 0){
                this.destinationWallet.setIsepCoins(this.destinationWallet.getIsepCoins() + this.isepCoins);
                this.originWallet.setIsepCoins(this.originWallet.getIsepCoins() - this.isepCoins);
                this.payed = "Transaction effectuée";
            } else {
                this.payed = "Transaction échouée : solde débiteur négatif";
            }
        } else {
            this.payed = "Transaction échouée : virement compte à compte impossible";
        }
    }

    public Wallet getOriginWallet() {
        return originWallet;
    }

    public Wallet getDestinationWallet() {
        return destinationWallet;
    }

    public int getIsepCoins() {
        return isepCoins;
    }

    public String isPayed() {
        return payed;
    }

}
