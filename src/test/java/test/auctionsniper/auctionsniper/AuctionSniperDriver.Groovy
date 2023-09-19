package test.auctionsniper.auctionsniper;

import spock.lang.Specification;

class ApplicationRunnerSpec extends Specification {

    static final String SNIPER_ID = "sniper";
    static final String SNIPER_PASSWORD = "sniper";
    AuctionSniperDriver driver;

    def setup() {
        // Setup code, this gets run before each test
    };

    def cleanup() {
        // Cleanup code, this gets run after each test
        if (driver) {
            driver.dispose()
        }
    }

    def "ensure sniper joins the auction and then loses"() {
        given: "an auction"
        def auction = new FakeAuctionServer() // Assuming a correct constructor or factory method

        when: "the sniper starts bidding in the auction"
        startBiddingIn(auction)

        then: "the sniper status shows as joining"
        // Assuming the driver has some mechanism to verify this

        and: "later the sniper has lost the auction"
        showsSniperHasLostAuction()
        // Again assuming the driver verifies this
    }

    void startBiddingIn(FakeAuctionServer auction) {
        Thread.startDaemon("Test Application") {
            try {
                Main.main(XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD, auction.getItemId())
            } catch (Exception e) {
                e.printStackTrace()
            }
        }

        driver = new AuctionSniperDriver(1000)
        driver.showsSniperStatus(STATUS_JOINING)
    }

    void showsSniperHasLostAuction() {
        driver.showsSniperStatus(STATUS_LOST)
    }
}