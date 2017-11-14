package com.example.edu.a0817moacn01c_3.DAO;

import android.content.Context;

/**
 * Created by ma on 13/11/17.
 */

public class DAODBGenero extends DatabaseHelper{
    public static final String TABLENAME = "generos";

    public static final String ID = "id";
    public static final String NAME = "nombre";

    public DAODBGenero(Context context) {
        super(context);
    }
}
