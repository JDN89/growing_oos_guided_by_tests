package org.example.endtoend;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

import static java.lang.String.format;

public class FakeAuctionServer {
    private final SingleMessageListener messageListener = new SingleMessageListener();
    public void startSellingItem() throws XMPPException {
        connection.connect();
        connection.login(format(ITEM_ID_AS_LOGIN, itemId),
                AUCTION_PASSWORD, AUCTION_RESOURCE);
        connection.getChatManager().addChatListener(
                new ChatManagerListener() {
                    public void chatCreated(Chat chat, boolean createdLocally) {
                        currentChat = chat;
                        chat.addMessageListener(messageListener);
                    }
                });
    }
    public void hasReceivedJoinRequestFromSniper() throws InterruptedException {
        messageListener.receivesAMessage(); 1
    }
    public void announceClosed() throws XMPPException {
        currentChat.sendMessage(new Message()); 2
    }
    public void stop() {
        connection.disconnect(); 3
    }
}
public class SingleMessageListener implements MessageListener {
    private final ArrayBlockingQueue<Message> messages =
            new ArrayBlockingQueue<Message>(1);
    public void processMessage(Chat chat, Message message) {
        messages.add(message);
    }
    public void receivesAMessage() throws InterruptedException {
        assertThat("Message", messages.poll(5, SECONDS), is(notNullValue())); 4
    }
}