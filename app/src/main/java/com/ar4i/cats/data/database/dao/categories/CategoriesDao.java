package com.ar4i.cats.data.database.dao.categories;

import com.ar4i.cats.data.database.DBhelper;
import com.ar4i.cats.data.database.dto.CategoryDto;

import java.util.List;

import io.reactivex.Single;

public class CategoriesDao implements ICategoriesDao {

    // region========================================FIELDS=========================================

    private DBhelper dBhelper;

    // endregion-------------------------------------FIELDS-----------------------------------------

    public CategoriesDao(DBhelper dBhelper) {
        this.dBhelper = dBhelper;
    }

    @Override
    public Single<List<CategoryDto>> getCategories() {
        return null;
    }

    @Override
    public void insertCategories(List<CategoryDto> entities) {

    }
}
