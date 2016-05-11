package com.jasonmckay.assignment62.domain.engine;

import java.io.Serializable;

/**
 * Created by JasonMckay on 19-Apr-16.
 */
public class EngineFactory implements Serializable
{
    private static EngineFactory engineFactory = null;

    public EngineFactory() {
    }

    public static EngineFactory getEngineFactoryInstance()
    {
        if(engineFactory == null)
        {
            return new EngineFactory();
        }
        return engineFactory;
    }

    public EngineType getEngineType(String fuelType)
    {
        if(fuelType.equalsIgnoreCase("Diesel"))
        {
            return new Diesel();
        }
        else if(fuelType.equalsIgnoreCase("Unleaded"))
        {
            return new UnleadedPetrol();
        }
        else
        {
            return new LeadedPetrol();
        }
    }
}
