package com.ar4i.cats.data.mappers;

import java.util.List;

public interface IMapper<V, D, E> {
   List<V> mapToViewModel(List<D> data);
   List<E> mapToEntity(List<D> data);
}
