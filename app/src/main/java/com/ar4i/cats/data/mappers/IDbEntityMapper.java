package com.ar4i.cats.data.mappers;

import java.util.List;

public interface IDbEntityMapper<E, D> {
    List<E> mapToDbEntity(List<D> data);
}
