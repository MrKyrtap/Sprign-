package com.example.dtos;

import java.util.List;

/**
 * Created by PatrykGrudnik on 18.03.2017.
 */
public class NameListDTO {
    private List<NameShortDTO> names;
    private Message message;

    public NameListDTO() {
    }


    public List<NameShortDTO> getNames() {
        return names;
    }

    public void setNames(List<NameShortDTO> names) {
        this.names = names;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
