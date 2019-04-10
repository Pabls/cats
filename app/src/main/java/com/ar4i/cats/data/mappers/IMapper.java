package com.ar4i.cats.data.mappers;

import java.util.List;

public interface IMapper<V, D> {
   List<V> mapToViewModel(List<D> data);
}
