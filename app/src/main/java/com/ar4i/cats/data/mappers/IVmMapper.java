package com.ar4i.cats.data.mappers;

import java.util.List;

public interface IVmMapper<V, D> {
   List<V> mapToViewModel(List<D> data);
}
