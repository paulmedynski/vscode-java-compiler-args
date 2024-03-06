package ca.medynski.test;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List foo = new ArrayList<String>();

        for (var value : foo)
        {
            System.out.println(value);
        }
    }
}