package io.keepcoding.rgs.everpobre.model.db.dao;

import android.test.AndroidTestCase;

import io.keepcoding.rgs.everpobre.model.Notebook;
import io.keepcoding.rgs.everpobre.model.db.DBHelper;

/**
 * Created by RamiroGarcia on 20/4/16.
 */
public class NotebookDAOTests extends AndroidTestCase {

    public void  testCanInsertNotebook(){
        DBHelper.configure("TestDB.sqlite", getContext());

        Notebook notebook = new Notebook(1, "nombre 1");

        NotebookDAO dao = new NotebookDAO();

        dao.insert(notebook);
    }
}
