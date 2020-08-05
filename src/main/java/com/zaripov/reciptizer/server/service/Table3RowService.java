package com.zaripov.reciptizer.server.service;

import com.zaripov.reciptizer.server.entity.Table3Row;
import java.util.List;

public interface Table3RowService {

    void saveTable3Row(List<Table3Row> table3Rows);

    List <Table3Row> findByIdRecipe(Integer idRecipe);
}