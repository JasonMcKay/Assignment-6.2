package com.jasonmckay.assignment62.domain.doors;

import java.io.Serializable;

/**
 * Created by JasonMckay on 19-Apr-16.
 */
public class NoDoorHandler extends DoorHandler  implements Serializable {
    @Override
    public String handleRequest(String request) {
        if(request.equalsIgnoreCase("No doors"))
        {
            return "No doors";
        }
        else
        {
            return successor.handleRequest(request);
        }
    }
}
