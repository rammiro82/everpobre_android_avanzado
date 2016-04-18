package io.keepcoding.everpobre.rgs;

import android.test.AndroidTestCase;

import io.keepcoding.rgs.everpobre.model.Notebook;

/**
 * Created by RamiroGarcia on 18/4/16.
 */
public class NotebookTests extends AndroidTestCase{

    public static final String NOTEBOOK_TITLE = "Notebook title";

    public void testCanCreateANotebook() {
        // sut = system under test
        final Notebook sut = new Notebook(1, NOTEBOOK_TITLE);

        assertNotNull(sut);
        assertEquals(1, sut.getId());
        assertEquals(NOTEBOOK_TITLE, sut.getName());
    }

    public void  testCreatingANotebookWithEmptyOrNullNameSetsDefaultName(){
        final Notebook sut = new Notebook(1, null);
        assertEquals(Notebook.DEFAULT_NAME, sut.getName());

        final Notebook sut2 = new Notebook(1, "");
        assertEquals(Notebook.DEFAULT_NAME, sut2.getName());
    }
}
