package com.zaripov.reciptizer.server.service;

import com.zaripov.reciptizer.server.entity.Table2Row;
import com.zaripov.reciptizer.server.repository.Table2RowRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Table2RowServiceImpl implements Table2RowService {

    private final Table2RowRepository table2RowRepository;

    public Table2RowServiceImpl(Table2RowRepository table2RowRepository) {
        this.table2RowRepository = table2RowRepository;
    }

    @Override
    public void saveTable2Row(List<Table2Row> table2Rows) {
        table2Rows.forEach(table2RowRepository::save);
    }

    @Override
    public List<Table2Row> findByIdRecipe(Integer idRecipe) {
        return table2RowRepository.findTable2RowByIdRecipe(idRecipe);
    }
}