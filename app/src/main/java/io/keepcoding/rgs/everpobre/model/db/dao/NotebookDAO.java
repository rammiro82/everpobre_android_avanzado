package io.keepcoding.rgs.everpobre.model.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

import io.keepcoding.rgs.everpobre.model.Notebook;
import io.keepcoding.rgs.everpobre.model.Notebooks;
import io.keepcoding.rgs.everpobre.model.db.DBConstants;
import io.keepcoding.rgs.everpobre.model.db.DBHelper;

public class NotebookDAO {


    private static final long INVALID_ID_DELETE_ALL_RECORDS = 0;

    private DBHelper db;

	public NotebookDAO() {
        db = DBHelper.getInstance();
	}

	public long insert(Notebook notebook) {
		if (notebook == null) {
			throw new IllegalArgumentException("Passing NULL NOTEBOOK, imbecile");
		}

		long id = db.getWritableDatabase().insert(DBConstants.TABLE_NOTEBOOK, null, this.getContentValues(notebook));
		notebook.setId(id);
		db.close();
		//

		return id;
	}

	public int update(long id, Notebook notebook) {
		if (notebook == null) {
			throw new IllegalArgumentException("Passing NULL NOTEBOOK, imbecile");
		}
		if (id < 1) {
			throw new IllegalStateException("Passing id imbecile");
		}

        // two diferents ways of doing the same.
		//int numberOfRowsUpdated = db.getWritableDatabase().update(TABLE_NOTEBOOK, this.getContentValues(notebook), KEY_NOTEBOOK_ID + "=" + id, null);
		int numberOfRowsUpdated = db.getWritableDatabase().update(DBConstants.TABLE_NOTEBOOK, this.getContentValues(notebook), DBConstants.KEY_NOTEBOOK_ID + "=?", new String[]{"" + id});

		db.close();
		//
		return numberOfRowsUpdated;
	}

	public void delete(long id) {

		if (id == INVALID_ID_DELETE_ALL_RECORDS) {
			db.getWritableDatabase().delete(DBConstants.TABLE_NOTEBOOK,  null, null);
		} else {
			db.getWritableDatabase().delete(DBConstants.TABLE_NOTEBOOK, DBConstants.KEY_NOTEBOOK_ID + " = " + id, null);
		}
		db.close();
		//
	}

	public void deleteAll() {
		delete(INVALID_ID_DELETE_ALL_RECORDS);
	}

	public static ContentValues getContentValues(Notebook notebook) {
		ContentValues content = new ContentValues();

		content.put(DBConstants.KEY_NOTEBOOK_NAME, notebook.getName());

		return content;
	}


	// convenience method

	public static Notebook elementFromCursor(final @NonNull Cursor c) {
		assert c != null;

		String name = c.getString(c.getColumnIndex(DBConstants.KEY_NOTEBOOK_NAME));
		long id = c.getLong(c.getColumnIndex(DBConstants.KEY_NOTEBOOK_ID));

		Notebook notebook = new Notebook(id, name);
		notebook.setId(id);

		return notebook;
	}


	/**
	 * Returns all NOTEBOOKs in DB inside a Cursor
	 * @return cursor with all records
	 */
	public Cursor queryCursor() {
		// select

		Cursor c = db.getReadableDatabase().query(DBConstants.TABLE_NOTEBOOK,
                DBConstants.allColumns,
                null,
                null,
                null,
                null,
                DBConstants.KEY_NOTEBOOK_ID);



		return c;
	}

	public Notebooks query() {

        List<Notebook> notebookList = new LinkedList<>();

		Cursor cursor = queryCursor();
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			do {
				Notebook notebook = elementFromCursor(cursor);
                notebookList.add(notebook);
			} while (cursor.moveToNext());
		}

        Notebooks notebooks = Notebooks.createNotebooks(notebookList);

		return notebooks;
	}


	/**
	 * Returns a NOTEBOOK object from its id
	 * @param id - the NOTEBOOK id in db
	 * @return NOTEBOOK object if found, null otherwise
	 */
	public @Nullable Notebook query(long id) {
        Notebook notebook = null;

		String where = DBConstants.KEY_NOTEBOOK_ID + "=" + id;
		Cursor c = db.getReadableDatabase().query(DBConstants.TABLE_NOTEBOOK, DBConstants.allColumns, where, null, null, null, null);
		if (c != null) {
			if (c.getCount() > 0) {
				c.moveToFirst();
                notebook = elementFromCursor(c);
			}
            c.close();
		}
		db.close();
		return notebook;
	}


}
