package net.osnixer.automessage.object;

import net.osnixer.automessage.object.interfaces.AutoMessage;

public class NormalAutoMessage implements AutoMessage {

    private final String message;

    public NormalAutoMessage(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
