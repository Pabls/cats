package com.ar4i.cats.data.database.dao.breeds;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ar4i.cats.data.database.DBhelper;
import com.ar4i.cats.data.database.dto.BreedDto;
import com.ar4i.cats.data.database.tables.Breeds;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class BreedsDao implements IBreedsDao {

    // region========================================FIELDS=========================================

    private DBhelper dBhelper;

    // endregion-------------------------------------FIELDS-----------------------------------------

    public BreedsDao(DBhelper dBhelper) {
        this.dBhelper = dBhelper;
    }

    // region========================================PUBLIC METHODS=================================

    @Override
    public Single<List<BreedDto>> getBreeds() {
        return Single.create(emitter -> {
            List<BreedDto> breedEntities = new ArrayList<>();
            Cursor cursor = null;
            try {
                SQLiteDatabase db = this.dBhelper.getWritableDatabase();
                cursor = db.rawQuery(Breeds.getBreedsSelectionCommand(), null);
                if (cursor.moveToFirst()) {
                    while (!cursor.isAfterLast()) {
                        String id = cursor.getString(cursor.getColumnIndex(Breeds.getID()));
                        String name = cursor.getString(cursor.getColumnIndex(Breeds.getNAME()));
                        breedEntities.add(new BreedDto(id, name));
                        cursor.moveToNext();
                    }
                }
            } catch (Exception ex) {
                closeConnection(cursor);
                emitter.onError(ex);
            } finally {
                closeConnection(cursor);
                emitter.onSuccess(breedEntities);
            }
        });
    }

    @Override
    public void insertBreeds(List<BreedDto> entities){
            try {
                SQLiteDatabase db = this.dBhelper.getWritableDatabase();
                for(BreedDto breedDto : entities){
                    ContentValues cv = Breeds.toContentValues(breedDto.getId(), breedDto.getName());
                    db.replace(Breeds.getTableName(), null, cv);
                }
            } catch (Exception ex) {
            } finally {
                closeConnection(null);
            }
    }

    // endregion-------------------------------------PUBLIC METHODS---------------------------------

    // region========================================PRIVATE METHODS================================

    private void closeConnection(Cursor cursor) {
        if (cursor != null && !cursor.isClosed())
            cursor.close();
        if (dBhelper != null)
            dBhelper.close();
    }

    // endregion-------------------------------------PRIVATE METHODS--------------------------------
}
