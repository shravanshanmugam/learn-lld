package com.shravan.learn.auction;

import java.util.Timer;
import java.util.TimerTask;

// AuctionSystem -> Users, Listings, user Notifications
//                  searchListing, createListing(Listing) [startAuctionTimer],
//                  placeBid(Listing, Bid), notify(Bidders)

// User -> name, email, pwd
// Notification -> recipient User, content, NotificationType, timestamp

// Listing -> name, description, Category, createdAt, startingPrice, auctionDuration, owner User,
//            Bids, highest Bidder (winner), AuctionStatus
//            placeBid(Bid), closeAuction(), notifyBidders()

// Bid -> User, amount, timestamp
// AuctionStatus -> ACTIVE, CLOSED
public class AuctionMain {
    static Timer timer = new Timer();
    public static void main(String[] args) {
        Listing listing1 = new Listing(1, 10000);
        Listing listing2 = new Listing(2, 20000);
        startAuctionTimer(listing1);
        startAuctionTimer(listing2);
    }


    private static void startAuctionTimer(Listing listing) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                listing.closeAuction();
            }
        }, listing.getDuration());
    }
}
