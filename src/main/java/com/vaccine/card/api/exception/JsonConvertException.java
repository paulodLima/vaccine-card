package com.vaccine.card.api.exception;

import com.vaccine.card.api.util.MessagesUtil;

public class JsonConvertException extends RuntimeException {

    public JsonConvertException(MessageError messageError) {
        super(MessagesUtil.getMessage(messageError));
    }
}
