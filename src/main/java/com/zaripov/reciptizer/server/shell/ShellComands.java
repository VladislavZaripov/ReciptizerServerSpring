package com.zaripov.reciptizer.server.shell;

import com.zaripov.reciptizer.server.entity.Recipe;
import com.zaripov.reciptizer.server.service.RecipeService;
import com.zaripov.reciptizer.server.service.Table1Service;
import com.zaripov.reciptizer.server.service.Table2RowService;
import com.zaripov.reciptizer.server.service.Table3RowService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellComands {

    private final RecipeService recipeService;
    private final Table1Service table1Service;
    private final Table2RowService table2RowService;
    private final Table3RowService table3RowService;

    public ShellComands(RecipeService recipeService, Table1Service table1Service, Table2RowService table2RowService, Table3RowService table3RowService) {
        this.recipeService = recipeService;
        this.table1Service = table1Service;
        this.table2RowService = table2RowService;
        this.table3RowService = table3RowService;
    }

    @ShellMethod("Save Table1")
    public String saveTable1(){
        Recipe recipe = SampleRecipe.createRecipe1();
        table1Service.saveTable1(recipe.table1);
        return "Table1 is saved";
    }

    @ShellMethod("Save Table2Rows")
    public String saveTable2rows(){
        Recipe recipe = SampleRecipe.createRecipe1();
        table2RowService.saveTable2Row(recipe.rowsTable2);
        return "Table2Rows are saved";
    }

    @ShellMethod("Save Table3Rows")
    public String saveTable3rows(){
        Recipe recipe = SampleRecipe.createRecipe1();
        table3RowService.saveTable3Row(recipe.rowsTable3);
        return "Table3Rows are saved";
    }

    @ShellMethod("Save Recipe")
    public String saveRecipe(int id){
        Recipe recipe = SampleRecipe.createRecipe(id);
        recipeService.saveRecipe(recipe);
        return "Recipe are saved";
    }

    @ShellMethod("Save all recipes")
    public String save(){
        recipeService.saveRecipe(SampleRecipe.createRecipe(1));
        recipeService.saveRecipe(SampleRecipe.createRecipe(2));
        recipeService.saveRecipe(SampleRecipe.createRecipe(3));
        recipeService.saveRecipe(SampleRecipe.createRecipe(4));
        return "Recipe are saved";
    }
}