package com.ar4i.cats.data.mappers;

import java.util.List;

public interface IVmMapper<V, D, E> {
   List<V> mapToViewModel(List<D> data);
   List<E> mapToDbEntity(List<D> data);
}
