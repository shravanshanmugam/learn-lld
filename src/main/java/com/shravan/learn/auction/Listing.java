package com.shravan.learn.auction;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Listing {
    private final int id;
    // ...
    private final long duration;
    // ...

    public void closeAuction() {
        System.out.println("Closing Auction listing " + id);
    }
}
